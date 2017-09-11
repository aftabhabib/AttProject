package com.example.hungvannguyen.myapplication.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hungvannguyen.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_vtv,tv_vtc,tv_hctv,tv_nameChannel,tv_home;
    private LinearLayout ln_home,ln_home1;
    private RecyclerView rv_home;
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

        tv_home.setOnClickListener(this);
        tv_vtv.setOnClickListener(this);
        tv_hctv.setOnClickListener(this);
        tv_vtc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_home:
                ln_home.setVisibility(View.VISIBLE);
                ln_home1.setVisibility(View.GONE);

                break;
            case R.id.tv_vtv:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("vtv");
                break;
            case R.id.tv_vtc:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("vtc");
                break;
            case R.id.tv_hctv:
                ln_home.setVisibility(View.GONE);
                ln_home1.setVisibility(View.VISIBLE);
                tv_nameChannel.setText("hctv");
                break;

        }
    }
}
