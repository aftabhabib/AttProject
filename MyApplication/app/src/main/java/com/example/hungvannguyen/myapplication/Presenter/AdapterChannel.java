package com.example.hungvannguyen.myapplication.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hungvannguyen.myapplication.Model.Channel;
import com.example.hungvannguyen.myapplication.OnclickListener.clickListener;
import com.example.hungvannguyen.myapplication.R;

import java.util.List;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class AdapterChannel extends RecyclerView.Adapter<AdapterChannel.HolderChannel> {
    private List<Channel> channels;
    private Context context;
    private clickListener clickListener;

    public AdapterChannel(List<Channel> channels, Context context) {
        this.channels = channels;
        this.context = context;
    }

    @Override
    public HolderChannel onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_rv_channel,parent,false);
        HolderChannel holderChannel =new HolderChannel(view);
        return holderChannel;
    }

    @Override
    public void onBindViewHolder(HolderChannel holder, int position) {
       Channel channel = channels.get(position);
        Log.d("xxx",channel.getImg()+"");
        holder.imageView.setImageResource(channel.getImg());
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public void setClickListener(com.example.hungvannguyen.myapplication.OnclickListener.clickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class HolderChannel extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        public HolderChannel(final View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.iv_item_channel);
            itemView.setOnClickListener(this);
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        // run scale animation and make it bigger
                        Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_in_tv);
                        itemView.startAnimation(anim);
                        anim.setFillAfter(true);
                    } else {
                        // run scale animation and make it smaller
                        Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_out_tv);
                        itemView.startAnimation(anim);
                        anim.setFillAfter(true);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onClicked(v,getAdapterPosition(),channels.get(getAdapterPosition()).getUrl());
            }
        }
    }
}
