package com.coder.guoy.recyclerview.ui;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coder.guoy.recyclerview.R;

public class PlayAppBarLayout extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_app_bar_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        //设置达到某一个状态之后的出现的效果
        mCollapsingToolbarLayout.setContentScrimColor(Color.BLUE);
        //设置达到某一个状态之后的状态栏出现的效果
        mCollapsingToolbarLayout.setStatusBarScrimColor(Color.RED);//无效果
    }
}
