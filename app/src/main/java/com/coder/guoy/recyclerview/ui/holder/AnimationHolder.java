package com.coder.guoy.recyclerview.ui.holder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityAnimationHolderBinding;
import com.coder.guoy.recyclerview.ui.animation.DrawableAnimation;
import com.coder.guoy.recyclerview.ui.animation.PropertyAnimation;
import com.coder.guoy.recyclerview.ui.animation.ViewAnimation;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月31日
 * @Descrpiton:
 */
public class AnimationHolder extends MvvmBaseActivity<ActivityAnimationHolderBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_holder);
        showContentView();
        bindingView.animationholder.textviewTitle.setText("Animation");
        bindingView.animationholder.toolbarBack.setOnClickListener(this);
        bindingView.button12.setOnClickListener(this);
        bindingView.button13.setOnClickListener(this);
        bindingView.button14.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.button12:
                startActivity(new Intent(AnimationHolder.this, DrawableAnimation.class));
                break;
            case R.id.button13:
                startActivity(new Intent(AnimationHolder.this, ViewAnimation.class));
                break;
            case R.id.button14:
                startActivity(new Intent(AnimationHolder.this, PropertyAnimation.class));
                break;
        }
    }


}
