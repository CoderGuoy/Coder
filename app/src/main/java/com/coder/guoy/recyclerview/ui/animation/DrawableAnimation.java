package com.coder.guoy.recyclerview.ui.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityDrawableAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月5日
 * @Descrpiton:帧动画
 */
public class DrawableAnimation extends MvvmBaseActivity<ActivityDrawableAnimationBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        showContentView();
        bindingView.drawableToolbar.textviewTitle.setText("帧动画");
        bindingView.drawableToolbar.toolbarBack.setOnClickListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable animationDrawable = (AnimationDrawable) bindingView.drawableAnimation.getDrawable();
        animationDrawable.start();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
