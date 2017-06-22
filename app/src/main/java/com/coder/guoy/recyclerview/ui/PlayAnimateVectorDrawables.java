package com.coder.guoy.recyclerview.ui;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayAnimateVectorDrawablesBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月21日
 * @Descrpiton:AnimateVectorDrawables|矢量图片动画
 */
public class PlayAnimateVectorDrawables extends MvvmBaseActivity<ActivityPlayAnimateVectorDrawablesBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_animate_vector_drawables);
        showContentView();
        bindingView.animatevectordrawable.textviewTitle.setText("Animate Vector Drawables|矢量图片动画");
        bindingView.animatevectordrawable.toolbarBack.setOnClickListener(this);
        bindingView.btnSuprise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_suprise:
                //笑脸
                ((Animatable) bindingView.imageSmile.getDrawable()).start();
                //红心
                ((Animatable) bindingView.imageRedheart.getDrawable()).start();
                //bonc
                bindingView.imageBonc.setVisibility(View.VISIBLE);
                ((Animatable) bindingView.imageBonc.getDrawable()).start();
                //线性心
                bindingView.imageHeart.setVisibility(View.VISIBLE);
                ((Animatable) bindingView.imageHeart.getDrawable()).start();
                break;
        }
    }
}
