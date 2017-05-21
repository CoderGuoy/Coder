package com.coder.guoy.recyclerview.ui.coordinator;

import android.graphics.Color;
import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayCoordinatorToolbarBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月24日
 * @Descrpiton:CoordinatorLayout，APPBarLayout，CollapsingTabLayout实现折叠头布局
 */
public class PlayCoordinatorToolbar extends MvvmBaseActivity<ActivityPlayCoordinatorToolbarBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_coordinator_toolbar);
        showContentView();

        //设置Collapsing折叠后文字颜色
        bindingView.collapsingtoolbar.setCollapsedTitleTextColor(Color.WHITE);
        //设置Collapsing未折叠文字颜色
        bindingView.collapsingtoolbar.setExpandedTitleColor(Color.BLACK);
    }

}
