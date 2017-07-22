package com.coder.guoy.recyclerview.view.alipay;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.databinding.ItemClassificationBinding;
import com.coder.guoy.recyclerview.databinding.ProjectItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version:V1.0
 * @Author:Guoy
 * @CreateTime:2017/7/19
 * @Descrpiton:仿支付宝小应用界面适配器模式
 */
public class Classification extends LinearLayout {
    private List<String> list = new ArrayList<String>();
    private List<List> contentList = new ArrayList<List>();
    private RecyclerView recyclerView;
    private TitleAdapter titleadapter;
    private ContentAdapter contentAdapter;
    private ItemCallBackListener itemCallBackListener;

    public Classification(Context context) {
        super(context);
        init(context, null);
    }

    public Classification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Classification(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.classification_zfb, this, true);
        recyclerView = (RecyclerView) view.findViewById(R.id.classification_zfb);
    }

    /**
     * @param titleList   标题集合
     * @param contentlist 内容集合
     */
    public void setList(List<String> titleList, List<List> contentlist) {
        list = titleList;
        contentList = contentlist;
        titleadapter = new TitleAdapter(getContext(), list, contentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(titleadapter);
    }

    public ItemCallBackListener getItemCallBackListener() {
        return itemCallBackListener;
    }

    public void setItemCallBackListener(ItemCallBackListener itemCallBackListener) {
        this.itemCallBackListener = itemCallBackListener;
    }

    /**
     * 标题适配器
     */
    private class TitleAdapter extends RecyclerView.Adapter {
        private List<String> titleList;
        private List<List> contentList;
        private LayoutInflater mInflater;
        private ItemClassificationBinding normalBinding;

        public TitleAdapter(Context context, List<String> titleList, List<List> contentList) {
            mInflater = LayoutInflater.from(context);
            this.titleList = titleList;
            this.contentList = contentList;
        }

        private class NormalViewHolder extends RecyclerView.ViewHolder {
            public RecyclerView contentRecycler;
            public TextView title;

            public NormalViewHolder(View itemView) {
                super(itemView);
                contentRecycler = normalBinding.recyclerContent;
                title = normalBinding.textTitle;
            }
        }

        // 获取条目数量
        @Override
        public int getItemCount() {
            return titleList.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_classification, parent, false);
            return new NormalViewHolder(normalBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            NormalViewHolder vh = (NormalViewHolder) holder;
            vh.title.setText(titleList.get(position));
            contentAdapter = new ContentAdapter(getContext(), contentList.get(position));
            vh.contentRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
            vh.contentRecycler.setAdapter(contentAdapter);
        }
    }

    /**
     * 内容适配器
     */
    public class ContentAdapter extends RecyclerView.Adapter {

        private List<String> contentList;
        private LayoutInflater mInflater;
        private ProjectItemBinding contentBinding;

        public ContentAdapter(Context context, List<String> contentList) {
            mInflater = LayoutInflater.from(context);
            this.contentList = contentList;
        }

        public class ContentHolder extends RecyclerView.ViewHolder {

            public TextView text;
            public ImageView image;
            public FrameLayout layout;

            public ContentHolder(View itemView) {
                super(itemView);
                text = contentBinding.text;
                image = contentBinding.beibiimage;
                layout = contentBinding.item;
            }
        }

        @Override
        public int getItemCount() {
            return contentList.size();
        }

        @Override
        public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            contentBinding = DataBindingUtil.inflate(mInflater, R.layout.project_item, parent, false);
            return new ContentHolder(contentBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ContentHolder ch = (ContentHolder) holder;
            ch.text.setText(contentList.get(position));
            ch.layout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemCallBackListener.itemOnClick(position, contentList.get(position));
                }
            });
        }
    }
}
