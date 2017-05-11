package com.coder.guoy.recyclerview.ui.animation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPropertyAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月10日
 * @Descrpiton:
 */
public class PropertyAnimation extends MvvmBaseActivity<ActivityPropertyAnimationBinding> implements View.OnClickListener {

    private WindowManager manager;
    private int width;
    private int height;
    private ObjectAnimator alpha;
    private ObjectAnimator scaleX;
    private ObjectAnimator scaleY;
    private ObjectAnimator translateX;
    private ObjectAnimator translateY;
    private ObjectAnimator rotation;
    private ObjectAnimator rotationX;
    private ObjectAnimator rotationY;
    public static final int TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        showContentView();
        initView();
        initListener();
        initAnimatior();
    }

    private void initView() {
        manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        //获取屏幕宽高
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();
        bindingView.propertyToolbar.textviewTitle.setText("Property Animation");
    }

    private void initListener() {
        bindingView.propertyToolbar.toolbarBack.setOnClickListener(this);
        bindingView.btnAlpah.setOnClickListener(this);
        bindingView.scalex.setOnClickListener(this);
        bindingView.scaley.setOnClickListener(this);
        bindingView.rotation.setOnClickListener(this);
        bindingView.rotationx.setOnClickListener(this);
        bindingView.rotationy.setOnClickListener(this);
        bindingView.translatex.setOnClickListener(this);
        bindingView.translatey.setOnClickListener(this);
    }

    private void initAnimatior() {
        //alpha:透明度 默认值是1（不透明），0代表完全透明（不可见）
        alpha = ObjectAnimator.ofFloat(bindingView.imageviewMove, "alpha", 1, 0, 1);
        //scaleX和scaleY：围绕支点进行2D缩放 0是缩放到无，1是本身大小
        scaleX = ObjectAnimator.ofFloat(bindingView.imageviewMove, "scaleX", 1f, 1.4f, 1f);
        scaleY = ObjectAnimator.ofFloat(bindingView.imageviewMove, "scaleY", 1f, 1.4f, 1f);
        //translationX和translationY:控制View在布局中的位置，可以理解为位移
        translateX = ObjectAnimator.ofFloat(bindingView.imageviewMove, "translationX", 0, -width, 0);
        translateY = ObjectAnimator.ofFloat(bindingView.imageviewMove, "translationY", 0, -height, 0);
        //rotation、rotationX和rotationY: 控制View围绕支点的2D和3D旋转
        rotation = ObjectAnimator.ofFloat(bindingView.imageviewMove, "rotation", 0, 60, 0);
        rotationX = ObjectAnimator.ofFloat(bindingView.imageviewMove, "rotationX", 0, 60, 0);
        rotationY = ObjectAnimator.ofFloat(bindingView.imageviewMove, "rotationY", 0, 60, 0);
        //组合动画
        //AnimatorSet set = new AnimatorSet();
        //set.playToghter() 同时执行多个
        //set.after(Animator anim) 将现有动画插入到传入的动画之后执行
        //set.after(long delay) 将现有动画延迟指定毫秒后执行
        //set.before(Animator anim) 将现有动画插入到传入的动画之前执行
        //set.with(Animator anim) 将现有动画和传入的动画同时执行
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativelayout);
        //设置过度动画
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1);
        scale.setDuration(500);
        //设置布局动画的显示属性 LayoutAnimationController参数(需要作用的动画，每个子View显示的Delay时间)
        LayoutAnimationController lac = new LayoutAnimationController(scale, 0.5f);
        //当delay时间不为0时，可以设置子View的显示顺序 顺序-NORMAL 随机-RANDOM 反序REVERSE
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        rl.setLayoutAnimation(lac);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_alpah:
                alpha.setDuration(TIME);
                alpha.start();
                break;
            case R.id.scalex:
                scaleX.setDuration(TIME);
                scaleX.start();
                break;
            case R.id.scaley:
                scaleY.setDuration(TIME);
                scaleY.start();
                break;
            case R.id.translatex:
                translateX.setDuration(TIME);
                translateX.start();
                break;
            case R.id.translatey:
                translateY.setDuration(TIME);
                translateY.start();
                break;
            case R.id.rotation:
                rotation.setDuration(TIME);
                rotation.start();
                break;
            case R.id.rotationx:
                rotationX.setDuration(TIME);
                rotationX.start();
                break;
            case R.id.rotationy:
                rotationY.setDuration(TIME);
                rotationY.start();
                break;
        }
    }
}
