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

import com.coder.guoy.recyclerview.databinding.ItemHomeBannerBinding;
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
    private ItemHomeBinding normalBindingView;
    private ItemHomeBannerBinding bannerBindView;
    private int bannerType = 0; // 第一种ViewType，头部banner
    private int normalType = 1; // 第二种ViewType，正常的item

    public HomeAdapter(Context context, String[] model, String[] describe) {
        mInflater = LayoutInflater.from(context);
        this.model = model;
        this.describe = describe;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if ((position == 0)) {
            return bannerType;
        } else {
            return normalType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == bannerType) {
            bannerBindView = DataBindingUtil.inflate(mInflater, R.layout.item_home_banner, parent, false);
            return new BannerViewHolder(bannerBindView.getRoot());
        } else {
            normalBindingView = DataBindingUtil.inflate(mInflater, R.layout.item_home, parent, false);
            return new NormalViewHolder(normalBindingView.getRoot());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BannerViewHolder) {//展示banner
            BannerViewHolder bvh = (BannerViewHolder) holder;
        } else {
            final NormalViewHolder vh = (NormalViewHolder) holder;
            vh.title.setText(model[position - 1]);
            vh.describe.setText(describe[position - 1]);
            normalBindingView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 1://Material Design
                            mContext.startActivity(new Intent(mContext, MaterialDesignHolder.class));
                            break;
                        case 2://RecyclerView
                            mContext.startActivity(new Intent(mContext, RecyclerViewHolder.class));
                            break;
                        case 3://CardView http://www.tuicool.com/articles/zyIbyyj
                            mContext.startActivity(new Intent(mContext, PlayCardView.class));
                            break;
                        case 4://Customize
                            mContext.startActivity(new Intent(mContext, CustomizeHolder.class));
                            break;
                        case 5://Animation
                            mContext.startActivity(new Intent(mContext, AnimationHolder.class));
                            break;
                        case 6://Design Pattern
                            mContext.startActivity(new Intent(mContext, DesignPatternHolder.class));
                            break;
                        case 7://
                            break;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return model.length;
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView title;
        public TextView describe;

        public NormalViewHolder(View itemView) {
            super(itemView);
            cardView = normalBindingView.homeCardview;
            title = normalBindingView.homeText;
            describe = normalBindingView.textDescribe;
        }
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        public CardView banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = bannerBindView.viewBanner;
        }
    }
}
