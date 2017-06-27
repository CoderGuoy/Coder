package com.coder.guoy.recyclerview.ui;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

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
    private boolean isClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_animate_vector_drawables);
        showContentView();
        bindingView.animatevectordrawable.textviewTitle.setText("Animate Vector Drawables|矢量图片动画");
        bindingView.animatevectordrawable.toolbarBack.setOnClickListener(this);
        bindingView.btnSuprise.setOnClickListener(this);
        bindingView.imageSmile.setOnClickListener(this);
        bindingView.imageRedheart.setOnClickListener(this);
        bindingView.imageRotate.setOnClickListener(this);
        bindingView.imageMoto.setOnClickListener(this);
        bindingView.imageAndroid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_suprise:
                //bonc
                bindingView.imageBonc.setVisibility(View.VISIBLE);
                ((Animatable) bindingView.imageBonc.getDrawable()).start();
                //线性心
                bindingView.imageHeart.setVisibility(View.VISIBLE);
                ((Animatable) bindingView.imageHeart.getDrawable()).start();
                break;
            case R.id.image_smile://笑脸
                VectorDrawableClick(R.drawable.animated_to_smile, R.drawable.animated_to_sad,
                        bindingView.imageSmile);
                break;
            case R.id.image_redheart://红心
                VectorDrawableClick(R.drawable.animated_red_heartfull, R.drawable.animated_red_heartempty,
                        bindingView.imageRedheart);
                break;
            case R.id.image_rotate://旋转
                ((AnimatedVectorDrawable) bindingView.imageRotate.getDrawable()).start();
                break;
            case R.id.image_moto://摩托车
                ((AnimatedVectorDrawable) bindingView.imageMoto.getDrawable()).start();
                break;
            case R.id.image_android://电池
                ((AnimatedVectorDrawable) bindingView.imageAndroid.getDrawable()).start();
                break;
        }
    }

    /**
     * 点击启动SVG动画
     * 点击状态公用(待解决)
     *
     * @param drawablestart 开始效果
     * @param drawableend   结束效果
     * @param view          需要操作的View
     */
    private void VectorDrawableClick(@DrawableRes int drawablestart, @DrawableRes int drawableend,
                                     ImageView view) {
        AnimatedVectorDrawable heartFull = (AnimatedVectorDrawable) getDrawable(drawablestart);
        AnimatedVectorDrawable heartEmpty = (AnimatedVectorDrawable) getDrawable(drawableend);
        AnimatedVectorDrawable heartAnimated = isClick ? heartFull : heartEmpty;
        view.setImageDrawable(heartAnimated);
        if (heartAnimated != null) {
            heartAnimated.start();
        }
        isClick = !isClick;
    }
}
