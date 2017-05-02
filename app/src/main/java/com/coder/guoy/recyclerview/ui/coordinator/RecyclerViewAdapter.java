package com.coder.guoy.recyclerview.ui.coordinator;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.databinding.ItemSampleBinding;
import com.coder.guoy.recyclerview.databinding.ItemWelfareFooterBinding;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemSampleBinding normalBinding;
    private ItemWelfareFooterBinding footBinding;

    public RecyclerViewAdapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            textView = normalBinding.itemTextview;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_sample, parent, false);
        return new NormalViewHolder(normalBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NormalViewHolder vh = (NormalViewHolder) holder;
        vh.textView.setText(mList.get(position));
    }

}

