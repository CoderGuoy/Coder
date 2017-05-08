package com.coder.guoy.recyclerview.ui.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityViewAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月5日
 * @Descrpiton:视图动画
 */
public class ViewAnimation extends MvvmBaseActivity<ActivityViewAnimationBinding> implements View.OnClickListener {

    private static final int DURATION = 1000;
    private AlphaAnimation alpha;
    private RotateAnimation rotate;
    private TranslateAnimation translate;
    private ScaleAnimation scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        showContentView();
        bindingView.alpha.setOnClickListener(this);
        bindingView.rotate.setOnClickListener(this);
        bindingView.translate.setOnClickListener(this);
        bindingView.scale.setOnClickListener(this);
        bindingView.set.setOnClickListener(this);
        initAnimation();
    }

    private void initAnimation() {
        alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(DURATION);
        rotate = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(DURATION);
        translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, -200,
                TranslateAnimation.RELATIVE_TO_SELF, 0);
        translate.setDuration(DURATION);
        scale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(DURATION);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                bindingView.imageView.startAnimation(alpha);
                break;
            case R.id.rotate:
                bindingView.imageView.startAnimation(rotate);
                break;
            case R.id.translate:
                bindingView.imageView.startAnimation(translate);
                break;
            case R.id.scale:
                bindingView.imageView.startAnimation(scale);
                break;
            case R.id.set:
                AnimationSet set = new AnimationSet(true);
                set.setDuration(DURATION);
                set.addAnimation(alpha);
                set.addAnimation(rotate);
                set.addAnimation(translate);
                set.addAnimation(scale);
                bindingView.imageView.startAnimation(set);
                break;
        }
    }
}
