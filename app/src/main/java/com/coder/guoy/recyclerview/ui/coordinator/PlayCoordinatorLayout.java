package com.coder.guoy.recyclerview.ui.coordinator;

import android.graphics.Color;
import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayCoordinatorLayoutBinding;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;
/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月24日
 * @Descrpiton:CoordinatorLayout，APPBarLayout，CollapsingTabLayout实现折叠头布局
 */
public class PlayCoordinatorLayout extends MvvmBaseActivity<ActivityPlayCoordinatorLayoutBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_coordinator_layout);
        StatusBarUtil.setColor(PlayCoordinatorLayout.this, CommonUtils.getColor(R.color.colorTheme),0);
        showContentView();

        //设置Collapsing文字颜色
        bindingView.collapsingtoolbar.setCollapsedTitleTextColor(Color.WHITE);
        //设置达到某一个状态之后的出现的效果
        bindingView.collapsingtoolbar.setContentScrimColor(CommonUtils.getColor(R.color.colorTheme));
        //设置达到某一个状态之后的状态栏出现的效果
        bindingView.collapsingtoolbar.setStatusBarScrimColor(CommonUtils.getColor(R.color.colorTheme));//无效果
    }

}
