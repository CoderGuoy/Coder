package com.coder.guoy.recyclerview.ui;

import android.animation.Animator;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayRevealEffectBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月13日
 * @Descrpiton:
 */
public class PlayRevealEffect extends MvvmBaseActivity<ActivityPlayRevealEffectBinding> implements View.OnClickListener {

    private boolean isFirst = true;
    private Animator animator;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_reveal_effect);
        showContentView();
        GetPiexels();
        bindingView.revealeffect.textviewTitle.setText("Reveal Effect|揭示效果");
        bindingView.revealeffect.toolbarBack.setOnClickListener(this);
        bindingView.btnRevealeffect.setOnClickListener(this);
    }

    private void GetPiexels() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        // 屏幕宽度（像素）
        width = metric.widthPixels;
        // 屏幕高度（像素）
        height = metric.heightPixels;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_revealeffect:
                if (isFirst) {
                    animator = ViewAnimationUtils.createCircularReveal(
                            bindingView.viewRevealeffect,
                            width / 2,
                            height / 2,
                            0,
                            height
                    );
                    isFirst = false;
                } else {
                    animator = ViewAnimationUtils.createCircularReveal(
                            bindingView.viewRevealeffect,
                            0,
                            0,
                            height,
                            0
                    );
                    isFirst = true;
                }
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (!isFirst) {
                            bindingView.viewRevealeffect.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (isFirst) {
                            bindingView.viewRevealeffect.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.setDuration(500);
                animator.start();
                break;
        }
    }
}
