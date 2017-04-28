package com.coder.guoy.recyclerview.ui.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityTabLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月26日
 * @Descrpiton:TabLayout|横向标签布局
 */
public class PlayTabLayout extends MvvmBaseActivity<ActivityTabLayoutBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        showContentView();
        bindingView.includeToolbar.textviewTitle.setText("TabLayout");
        bindingView.includeToolbar.toolbarBack.setOnClickListener(this);
        List<String> mList = new ArrayList<String>();
        for (int i = 1; i <= 8; i++) {
            mList.add("Tab" + i);
        }
        //给viewpager设置adapter
        bindingView.viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mList));
        //setupWithViewPagerb必须在viewpager之后
        bindingView.tablayout.setupWithViewPager(bindingView.viewpager);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
