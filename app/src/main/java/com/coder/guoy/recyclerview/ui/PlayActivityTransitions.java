package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayTransitionsBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:
 * @Descrpiton:ActivityTransitions|转场动画
 */
public class PlayActivityTransitions extends MvvmBaseActivity<ActivityPlayTransitionsBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_transitions);
        showContentView();
        bindingView.activitytransition.textviewTitle.setText("ActivityTransitions|转场动画");
        bindingView.activitytransition.toolbarBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
        }
    }
}
