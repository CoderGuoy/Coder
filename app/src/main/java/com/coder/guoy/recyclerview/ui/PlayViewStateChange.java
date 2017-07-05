package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayViewStateChangeBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月19日
 * @Descrpiton:ViewstateChanges|视图状态改变
 */
public class PlayViewStateChange extends MvvmBaseActivity<ActivityPlayViewStateChangeBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_view_state_change);
        showContentView();
        setTitle("View State Changes|视图状态改变");
    }
}
