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
import com.coder.guoy.recyclerview.ui.PlayCardView;
import com.coder.guoy.recyclerview.ui.holder.AnimationHolder;
import com.coder.guoy.recyclerview.ui.holder.CustomizeHolder;
import com.coder.guoy.recyclerview.ui.holder.DesignPatternHolder;
import com.coder.guoy.recyclerview.ui.holder.MaterialDesignHolder;
import com.coder.guoy.recyclerview.ui.holder.RecyclerViewHolder;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月11日
 * @Descrpiton:
 */
public class HomeAdapter extends RecyclerView.Adapter {
    private String[] model;
    private String[] describe;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemHomeBinding bindingView;

    public HomeAdapter(Context context, String[] model, String[] describe) {
        mInflater = LayoutInflater.from(context);
        this.model = model;
        this.describe = describe;
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
        vh.title.setText(model[position]);
        vh.describe.setText(describe[position]);
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
                    case 3://Customize
                        mContext.startActivity(new Intent(mContext, CustomizeHolder.class));
                        break;
                    case 4://Animation
                        mContext.startActivity(new Intent(mContext, AnimationHolder.class));
                        break;
                    case 5://Design Pattern
                        mContext.startActivity(new Intent(mContext, DesignPatternHolder.class));
                        break;
                    case 6://
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
        public TextView title;
        public TextView describe;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = bindingView.homeCardview;
            title = bindingView.homeText;
            describe = bindingView.textDescribe;
        }
    }
}
