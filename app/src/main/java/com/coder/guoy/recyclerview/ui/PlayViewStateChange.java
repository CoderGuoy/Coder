package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayViewStateChangeBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月19日
 * @Descrpiton:ViewstateChanges|视图状态改变
 */
public class PlayViewStateChange extends MvvmBaseActivity<ActivityPlayViewStateChangeBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_view_state_change);
        showContentView();
        bindingView.viewstatechange.textviewTitle.setText("View State Changes|视图状态改变");
        bindingView.viewstatechange.toolbarBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
