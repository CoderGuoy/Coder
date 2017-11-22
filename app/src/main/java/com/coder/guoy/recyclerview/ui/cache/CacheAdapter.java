package com.coder.guoy.recyclerview.ui.cache;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.bean.ImageBean;
import com.coder.guoy.recyclerview.databinding.ItemCacheBinding;
import com.coder.guoy.recyclerview.utils.GlideUtils;

import java.util.List;

/**
 * @Version:V1.0
 * @Author:CoderGuoy
 * @CreateTime:2017年12月22日
 * @Descrpiton:
 */
public class CacheAdapter extends RecyclerView.Adapter {
    private List<ImageBean> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemCacheBinding binding;

    public CacheAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setNewData(List data) {
        mList = data;
        notifyDataSetChanged();
    }

    public void removeItems(List mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textTitle;
        public CardView cardView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            imageView = binding.itemImage;
            textTitle = binding.itemText;
            cardView = binding.cardview;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(mInflater, R.layout.item_cache, parent, false);
        return new NormalViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final NormalViewHolder vh = (NormalViewHolder) holder;
        //设置图片
        if (mList.get(position).getImageUrl() != null) {
            GlideUtils.setImage(mContext,mList.get(position).getImageUrl(), vh.imageView);
        }
        //设置标题
        if (mList.get(position).getImgaeTitle() != null) {
            vh.textTitle.setText(mList.get(position).getImgaeTitle());
        }
    }

}
