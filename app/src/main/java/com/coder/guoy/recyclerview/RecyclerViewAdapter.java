package com.coder.guoy.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.guoy.recyclerview.databinding.ItemRecyclerTestBinding;
import com.coder.guoy.recyclerview.databinding.ItemRecyclerTestFooterBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:自定义加载更多
 * @UpDateAuthor:
 * @UpDateTime:
 * @UpDataWhat:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemRecyclerTestBinding normalBinding;
    private ItemRecyclerTestFooterBinding footBinding;

    private AnimationDrawable animationDrawable;

    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View

    private boolean hasMore = true;   // 变量，是否有更多数据
    private boolean fadeTips = false; // 变量，是否隐藏了底部的提示

    private Handler mHandler = new Handler(Looper.getMainLooper()); //获取主线程的Handler

    public RecyclerViewAdapter(Context context, List list, boolean hasMore) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
        this.hasMore = hasMore;
    }

    // 获取条目数量，之所以要加1是因为增加了一条footView
    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    // 自定义方法，获取列表中数据源的最后一个位置，比getItemCount少1，因为不计上footView
    public int getRealLastPosition() {
        return mList.size();
    }

    // 根据条目位置返回ViewType，以供onCreateViewHolder方法内获取不同的Holder
    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    // 正常item的ViewHolder
    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            textView = normalBinding.itemTextview;
        }
    }

    // 底部footView的ViewHolder
    private class FootViewHolder extends RecyclerView.ViewHolder {
        public TextView footText;
        public LinearLayout footLayout;
        public ImageView image;

        public FootViewHolder(View itemView) {
            super(itemView);
            footText = footBinding.itemTextview;
            footLayout = footBinding.layoutFoot;
            image = footBinding.imgProgress;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == normalType) {
            normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_recycler_test, parent, false);
            return new NormalViewHolder(normalBinding.getRoot());
        } else {
            footBinding = DataBindingUtil.inflate(mInflater, R.layout.item_recycler_test_footer, parent, false);
            return new FootViewHolder(footBinding.getRoot());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        // 如果是正常的imte，直接设置TextView的值
        if (holder instanceof NormalViewHolder) {
            NormalViewHolder vh = (NormalViewHolder) holder;
            vh.textView.setText(mList.get(position));
            vh.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "positon:"+position + "被点击", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            final FootViewHolder vh = (FootViewHolder) holder;
            // 只有获取数据为空时，hasMore为false，所以当我们拉到底部时基本都会首先显示“正在加载更多...”
            if (hasMore == true) {
                // 不隐藏footView提示
                fadeTips = false;
                if (mList.size() > 0) {
                    // 如果查询数据发现增加之后，就显示正在加载更多
                    vh.footText.setText("正在加载更多...");
                    //显示加载动画
                    vh.image.setVisibility(View.VISIBLE);
                    animationDrawable = (AnimationDrawable) vh.image.getDrawable();
                    animationDrawable.start();
                }
                //数据不足以显示整个页面，隐藏footView
                if (mList.size() < 10 & mList.size() > 0) {
                    //隐藏加载更多控件
                    vh.footLayout.setVisibility(View.GONE);
                }
            } else {
                if (mList.size() > 0) {//请求数据为空（非首次）
                    // 如果查询数据发现并没有增加时，就显示没有更多数据了
                    vh.footText.setText("你瞅啥！没了，别扯了！");
                    //隐藏加载动画
                    vh.image.setVisibility(View.GONE);
                    // 将fadeTips设置true
                    fadeTips = true;
                    // hasMore设为true是为了让再次拉到底时，会先显示正在加载更多
                    hasMore = true;
                } else {//请求数据为空（首次）
                    //隐藏加载更多控件
                    vh.footLayout.setVisibility(View.GONE);
                    // 将fadeTips设置true，隐藏footView提示
                    fadeTips = true;
                    Toast.makeText(mContext, "服务器暂未提供相关数据", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // 暴露接口，改变fadeTips的方法
    public boolean isFadeTips() {
        return fadeTips;
    }

    // 暴露接口，下拉刷新时，通过暴露方法将数据源置为空
    public void resetDatas() {
        mList = new ArrayList<>();
    }

    // 暴露接口，更新数据源，并修改hasMore的值，如果有增加数据，hasMore为true，否则为false
    public void updateList(List<String> list, boolean hasMore) {
        // 在原有的数据之上增加新数据
        if (list != null) {
            mList.addAll(list);
        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

}
