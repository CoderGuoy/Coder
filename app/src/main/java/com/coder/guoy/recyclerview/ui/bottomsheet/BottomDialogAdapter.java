package com.coder.guoy.recyclerview.ui.bottomsheet;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.databinding.ItemSampleBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;

import java.util.List;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/6/1
 * @Descrpiton:
 */
public class BottomDialogAdapter extends RecyclerView.Adapter {
    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemSampleBinding normalBinding;

    public BottomDialogAdapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_sample, parent, false);
        return new NormalViewHolder(normalBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NormalViewHolder vh = (NormalViewHolder) holder;
        vh.text.setText("条目:" + position);
        vh.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(position + "被点击");
            }
        });
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public NormalViewHolder(View itemView) {
            super(itemView);
            text = normalBinding.itemTextview;
        }
    }

}
