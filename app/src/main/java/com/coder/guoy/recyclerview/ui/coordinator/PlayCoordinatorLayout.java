package com.coder.guoy.recyclerview.ui.coordinator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;

public class PlayCoordinatorLayout extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_app_bar_layout);
        StatusBarUtil.setColor(PlayCoordinatorLayout.this, CommonUtils.getColor(R.color.colorTheme),0);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        //设置达到某一个状态之后的出现的效果
        mCollapsingToolbarLayout.setContentScrimColor(CommonUtils.getColor(R.color.colorTheme));
        //设置达到某一个状态之后的状态栏出现的效果
        mCollapsingToolbarLayout.setStatusBarScrimColor(CommonUtils.getColor(R.color.colorTheme));//无效果
    }

}
