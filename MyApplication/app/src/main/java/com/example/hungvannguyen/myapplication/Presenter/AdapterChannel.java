package com.example.hungvannguyen.myapplication.Presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class AdapterChannel extends RecyclerView.Adapter<AdapterChannel.HolderChannel> {
    @Override
    public HolderChannel onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HolderChannel holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderChannel extends RecyclerView.ViewHolder {
        public HolderChannel(View itemView) {
            super(itemView);
        }
    }
}
