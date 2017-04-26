package com.coder.guoy.recyclerview.ui.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.bean.GankIoDataBean;
import com.coder.guoy.recyclerview.databinding.ItemWelfareBinding;
import com.coder.guoy.recyclerview.utils.DensityUtil;
import com.coder.guoy.recyclerview.utils.GlideUtils;

import java.util.List;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 */
public class WelfareAnimationAdapter extends RecyclerView.Adapter {
    private List<GankIoDataBean.ResultsBean> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemWelfareBinding normalBinding;

    public WelfareAnimationAdapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mList.size() ;
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            imageView = normalBinding.itemImage;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_welfare, parent, false);
            return new NormalViewHolder(normalBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            NormalViewHolder vh = (NormalViewHolder) holder;
            GlideUtils.setImage(mContext, mList.get(position).getUrl(), vh.imageView);
            //设置图片的边距
            if (position % 2 == 0) {
                DensityUtil.setViewMargin(vh.imageView, false, 12, 6, 12, 0);
            } else {
                DensityUtil.setViewMargin(vh.imageView, false, 6, 12, 12, 0);
            }
            //添加动画属性
            setAnimator(vh);
    }

    public void setAnimator(NormalViewHolder vh) {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(vh.imageView, "scaleY", 0.8f, 1f).setDuration(500);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(vh.imageView, "scaleX", 0.8f, 1f).setDuration(500);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleX).with(scaleY);
        animSet.setDuration(500);
        animSet.start();
    }

}
