package com.coder.guoy.recyclerview.ui.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPropertyAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月4日
 * @Descrpiton:
 */
public class PropertyAnimation extends MvvmBaseActivity<ActivityPropertyAnimationBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        showContentView();
        initAnimation();
    }

    private void initAnimation() {
        ObjectAnimator move = ObjectAnimator.ofFloat(bindingView.imageviewMove, "translationY", -200);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(bindingView.imageviewMove, "scaleX", 0.5f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(bindingView.imageviewMove, "scaleY", 0.5f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.play(scaleX).with(scaleY);
        set.start();
    }
}
