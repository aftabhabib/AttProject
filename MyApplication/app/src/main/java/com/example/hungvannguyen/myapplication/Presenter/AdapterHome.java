package com.example.hungvannguyen.myapplication.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hungvannguyen.myapplication.Model.Home;
import com.example.hungvannguyen.myapplication.OnclickListener.clickListener;
import com.example.hungvannguyen.myapplication.R;

import java.util.List;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.HolderHome>{
    private List<Home> homeList;
    private Context context;

    public void setClickListener(com.example.hungvannguyen.myapplication.OnclickListener.clickListener clickListener) {
        this.clickListener = clickListener;
    }

    private clickListener  clickListener;


    public AdapterHome(List<Home> homeList, Context context) {
        this.homeList = homeList;
        this.context = context;
    }

    @Override
    public AdapterHome.HolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.item_rv_home,parent,false);
        HolderHome holderHome= new HolderHome(view);
        return holderHome;
    }

    @Override
    public void onBindViewHolder(AdapterHome.HolderHome holder, int position) {
       Home home= homeList.get(position);
        holder.textView.setText(home.getName());
        AdapterChannel adapterChannel = new AdapterChannel(home.getChannels(),context);
        Log.d("xxx",home.getChannels().get(position).getImg()+"");
        holder.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.rv.setAdapter(adapterChannel);
        adapterChannel.notifyDataSetChanged();
        adapterChannel.setClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class HolderHome extends RecyclerView.ViewHolder {
        private TextView textView;
        private RecyclerView rv;
        public HolderHome(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_item_namehome);
            rv= (RecyclerView) itemView.findViewById(R.id.rv_channel);
        }
    }
}
