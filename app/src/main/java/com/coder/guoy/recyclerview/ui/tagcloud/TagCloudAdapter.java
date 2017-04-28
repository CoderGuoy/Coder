package com.coder.guoy.recyclerview.ui.tagcloud;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.guoy.recyclerview.view.tagcloud.TagsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 */
public class TagCloudAdapter extends TagsAdapter {
    private List<String> mList = new ArrayList<String>();

    public TagCloudAdapter(String[] list) {
        mList.clear();
        Collections.addAll(mList, list);
    }

    //返回Tag数量
    @Override
    public int getCount() {
        return mList.size();
    }

    //返回每个Tag实例
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        TextView tv = new TextView(context);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(100, 100);
        tv.setLayoutParams(lp);
        tv.setText("No." + position);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    //返回Tag数据
    @Override
    public int getPopularity(int position) {
        return position % 7;
    }

    //针对每个Tag返回一个权重值，该值与ThemeColor和Tag初始大小有关
    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        ((TextView)view).setTextColor(themeColor);
    }
}
