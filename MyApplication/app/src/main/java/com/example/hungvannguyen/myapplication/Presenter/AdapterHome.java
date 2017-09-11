package com.example.hungvannguyen.myapplication.Presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.HolderHome>{
    @Override
    public AdapterHome.HolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterHome.HolderHome holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderHome extends RecyclerView.ViewHolder {
        public HolderHome(View itemView) {
            super(itemView);
        }
    }
}
