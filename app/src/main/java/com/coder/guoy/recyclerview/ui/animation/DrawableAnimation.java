package com.coder.guoy.recyclerview.ui.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityDrawableAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月5日
 * @Descrpiton:帧动画
 */
public class DrawableAnimation extends MvvmBaseActivity<ActivityDrawableAnimationBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        showContentView();
        setTitle("帧动画");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable animationDrawable = (AnimationDrawable) bindingView.drawableAnimation.getDrawable();
        animationDrawable.start();
    }
}
