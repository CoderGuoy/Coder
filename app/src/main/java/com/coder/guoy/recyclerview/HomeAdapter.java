package com.coder.guoy.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.guoy.recyclerview.databinding.ItemHomeBinding;
import com.coder.guoy.recyclerview.designpattern.StrategyDesign;
import com.coder.guoy.recyclerview.ui.PlayCardView;
import com.coder.guoy.recyclerview.ui.holder.AnimationHolder;
import com.coder.guoy.recyclerview.ui.holder.MaterialDesignHolder;
import com.coder.guoy.recyclerview.ui.holder.RecyclerViewHolder;
import com.coder.guoy.recyclerview.ui.tagcloud.TagCloudActivity;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月11日
 * @Descrpiton:
 */
public class HomeAdapter extends RecyclerView.Adapter {
    private String[] model;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemHomeBinding bindingView;

    public HomeAdapter(Context context, String[] model) {
        mInflater = LayoutInflater.from(context);
        this.model = model;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindingView = DataBindingUtil.inflate(mInflater, R.layout.item_home, parent, false);
        return new ViewHolder(bindingView.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.textView.setText(model[position]);
        bindingView.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0://Material Design
                        mContext.startActivity(new Intent(mContext, MaterialDesignHolder.class));
                        break;
                    case 1://RecyclerView
                        mContext.startActivity(new Intent(mContext, RecyclerViewHolder.class));
                        break;
                    case 2://CardView http://www.tuicool.com/articles/zyIbyyj
                        mContext.startActivity(new Intent(mContext, PlayCardView.class));
                        break;
                    case 3://3Dtouch
                        mContext.startActivity(new Intent(mContext, TagCloudActivity.class));
                        break;
                    case 4://Animation
                        mContext.startActivity(new Intent(mContext, AnimationHolder.class));
                        break;
                    case 5://Design Pattern
                        mContext.startActivity(new Intent(mContext, StrategyDesign.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.length;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = bindingView.homeCardview;
            textView = bindingView.homeText;
        }
    }
}
