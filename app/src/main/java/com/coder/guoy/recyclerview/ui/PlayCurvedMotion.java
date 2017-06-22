package com.coder.guoy.recyclerview.ui;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayCurvedMotionBinding;


/**
 * @Version:
 * @Author:
 * @CreateTime:2017年6月14日
 * @Descrpiton:CurvedMotion|曲线运动
 */
public class PlayCurvedMotion extends MvvmBaseActivity<ActivityPlayCurvedMotionBinding> implements View.OnClickListener {
    private ObjectAnimator animator;
    private Path path;
    private int width;
    private int height;
    private int accelerate_cubic = android.R.interpolator.accelerate_cubic;
    private int accelerate_decelerate = android.R.interpolator.accelerate_decelerate;
    private int accelerate_quad = android.R.interpolator.accelerate_quad;
    private int accelerate_quint = android.R.interpolator.accelerate_quint;
    private int anticipate = android.R.interpolator.anticipate;
    private int anticipate_overshoot = android.R.interpolator.anticipate_overshoot;
    private int bounce = android.R.interpolator.bounce;
    private int cycle = android.R.interpolator.cycle;
    private int decelerate_cubic = android.R.interpolator.decelerate_cubic;
    private int decelerate_quad = android.R.interpolator.decelerate_quad;
    private int decelerate_quint = android.R.interpolator.decelerate_quint;
    private int fast_out_linear_in = android.R.interpolator.fast_out_linear_in;
    private int fast_out_slow_in = android.R.interpolator.fast_out_slow_in;
    private int linear = android.R.interpolator.linear;
    private int linear_out_slow_in = android.R.interpolator.linear_out_slow_in;
    private int overshoot = android.R.interpolator.overshoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_curved_motion);
        showContentView();
        GetPiexels();
        bindingView.curvedmotion.textviewTitle.setText("Curved Motion|曲线运动");
        bindingView.curvedmotion.toolbarBack.setOnClickListener(this);
        bindingView.btnCurvedMotion.setOnClickListener(this);
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
            case R.id.btn_curved_motion:
                setCurvedMotion(bindingView.imageCurved1, accelerate_cubic);
                setCurvedMotion(bindingView.imageCurved2, accelerate_decelerate);
                setCurvedMotion(bindingView.imageCurved3, accelerate_quad);
                setCurvedMotion(bindingView.imageCurved4, accelerate_quint);
                setCurvedMotion(bindingView.imageCurved5, anticipate);
                setCurvedMotion(bindingView.imageCurved6, anticipate_overshoot);
                setCurvedMotion(bindingView.imageCurved7, bounce);
                setCurvedMotion(bindingView.imageCurved8, cycle);
                setCurvedMotion(bindingView.imageCurved9, decelerate_cubic);
                setCurvedMotion(bindingView.imageCurved10, decelerate_quad);
                setCurvedMotion(bindingView.imageCurved11, decelerate_quint);
                setCurvedMotion(bindingView.imageCurved12, fast_out_linear_in);
                setCurvedMotion(bindingView.imageCurved13, fast_out_slow_in);
                setCurvedMotion(bindingView.imageCurved14, linear);
                setCurvedMotion(bindingView.imageCurved15, linear_out_slow_in);
                setCurvedMotion(bindingView.imageCurved16, overshoot);
                break;
        }
    }

    /**
     * @param view
     * @param interpolator
     */
    private void setCurvedMotion(TextView view, int interpolator) {
        path = new Path();
        path.moveTo(view.getLeft(), view.getTop());
        path.lineTo(view.getLeft(), 600);
        animator = new ObjectAnimator().ofFloat(view, View.X, View.Y, path);
        animator.setInterpolator(new AnimationUtils().loadInterpolator(
                this, interpolator));
        animator.setDuration(2000);
        animator.start();
    }
}
