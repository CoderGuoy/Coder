package com.coder.guoy.recyclerview.ui;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayAnimateVectorDrawablesBinding;

public class PlayAnimateVectorDrawables extends MvvmBaseActivity<ActivityPlayAnimateVectorDrawablesBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_animate_vector_drawables);
        showContentView();
        bindingView.animatevectordrawable.textviewTitle.setText("Animate Vector Drawables|矢量图片动画");
        bindingView.animatevectordrawable.toolbarBack.setOnClickListener(this);
        bindingView.imageSmile.setOnClickListener(this);
        bindingView.btnGiveheart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.image_smile:
                ((Animatable) bindingView.imageSmile.getDrawable()).start();
                break;
            case R.id.btn_giveheart:
                bindingView.imageHeart.setVisibility(View.VISIBLE);
                Animatable animatable = (Animatable) bindingView.imageHeart.getDrawable();
                animatable.start();
        }
    }
}
