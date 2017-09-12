package com.example.hungvannguyen.myapplication.View;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hungvannguyen.myapplication.Model.Channel;
import com.example.hungvannguyen.myapplication.Model.Home;
import com.example.hungvannguyen.myapplication.OnclickListener.clickListener;
import com.example.hungvannguyen.myapplication.Presenter.AdapterChannel;
import com.example.hungvannguyen.myapplication.Presenter.AdapterHome;
import com.example.hungvannguyen.myapplication.R;
import com.example.hungvannguyen.myapplication.Ultis.Define;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, clickListener {
    private TextView tv_vtv,tv_vtc,tv_hctv,tv_nameChannel,tv_home;
    private LinearLayout ln_home,ln_home1;
    private RecyclerView rv_home,rv_home1;
    private List<Channel> channels;
    private List<Home> homeList;
    private AdapterHome adapterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControl();
    }

    private void getControl() {
        tv_vtv=(TextView)findViewById(R.id.tv_vtv);
        tv_home= (TextView) findViewById(R.id.tv_home);
        tv_vtc= (TextView) findViewById(R.id.tv_vtc);
        tv_hctv= (TextView) findViewById(R.id.tv_hctv);
        tv_nameChannel= (TextView) findViewById(R.id.tv_namechannel);
        ln_home= (LinearLayout) findViewById(R.id.ln_home);
        ln_home1= (LinearLayout) findViewById(R.id.ln_home1);
        rv_home= (RecyclerView) findViewById(R.id.rv_home);
        rv_home1= (RecyclerView) findViewById(R.id.rv_home1);


        tv_home.setOnClickListener(this);
        tv_vtv.setOnClickListener(this);
        tv_hctv.setOnClickListener(this);
        tv_vtc.setOnClickListener(this);
        channels=new ArrayList<>();
        homeList=new ArrayList<>();

        for (int i=0;i< 4;i++) {
            Channel channel = new Channel(R.drawable.vtv3, Define.url);
            channels.add(channel);
        }
            Home home = new Home("VTV",channels);
            Home home1 = new Home("VTC",channels);
            Home home2 = new Home("HTCV",channels);
        homeList.add(home);
        homeList.add(home1);
        homeList.add(home2);
        adapterHome=new AdapterHome(homeList,this);
        rv_home.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv_home.setAdapter(adapterHome);
        adapterHome.notifyDataSetChanged();
        showListChannel(channels);
        adapterHome.setClickListener(this);
    }

    @Override
    public void onClick(View v) {
        List<Channel> channels1 =new ArrayList<>();
        switch (v.getId()){
            case R.id.tv_home:
                ln_home.setVisibility(View.VISIBLE);
                ln_home1.setVisibility(View.GONE);

                break;
            case R.id.tv_vtv:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("vtv");
                for (int i=0;i< 5;i++) {
                    Channel channel = new Channel(R.drawable.vtv3, Define.url);
                    channels1.add(channel);
                }
                showListChannel(channels1);
                break;
            case R.id.tv_vtc:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("vtc");
                for (int i=0;i< 4;i++) {
                    Channel channel = new Channel(R.drawable.vtv3, Define.url);
                    channels1.add(channel);
                }
                showListChannel(channels1);
                break;
            case R.id.tv_hctv:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("hctv");
                for (int i=0;i< 2;i++) {
                    Channel channel = new Channel(R.drawable.vtv3, Define.url);
                    channels1.add(channel);
                }
                showListChannel(channels1);
                break;

        }
    }


    private void showListChannel(List<Channel> channels){
        AdapterChannel adapterChannel= new AdapterChannel(channels,this);
        rv_home1.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false));

        rv_home1.setAdapter(adapterChannel);
        adapterChannel.setClickListener(this);
        adapterChannel.notifyDataSetChanged();

    }

    @Override
    public void onClicked(View v, int position, String url) {
        openVideo(url);
    }

    private void openVideo(String url){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName(Define.IPTV_CORE_PACKAGE_NAME, Define.IPTV_CORE_CLASS_NAME);
            Uri videoUri = Uri.parse(url);
            intent.setDataAndType( videoUri, Define.dataTypeIntent );
            intent.setPackage( Define.packageMxPlayer );
            startActivity( intent );
        } catch (ActivityNotFoundException e) {
            // IPTV core app is not installed, let's ask the user to install it.
            showIptvCoreNotFoundDialog();
        }
    }
    public void showIptvCoreNotFoundDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_core_not_installed_title);
        builder.setMessage(R.string.dialog_core_not_installed_message);
        builder.setPositiveButton(R.string.dialog_button_install,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id)
                    {
                        try {
                            // try to open Google Play app first
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Define.maketdownloadMxPlayer)));
                        } catch (ActivityNotFoundException e) {
                            // if Google Play is not found for some reason, let's open browser
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Define.GoogleplayDownMxplayer)));
                        }
                    }
                });
        builder.setNegativeButton(R.string.dialog_button_cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id)
                    {
                        // if cancelled - just close the app
                    }
                });
        builder.setCancelable(false);
        builder.create().show();
    }
}
