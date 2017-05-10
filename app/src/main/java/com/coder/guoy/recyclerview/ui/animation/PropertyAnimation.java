package com.coder.guoy.recyclerview.ui.animation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPropertyAnimationBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年5月10日
 * @Descrpiton:
 */
public class PropertyAnimation extends MvvmBaseActivity<ActivityPropertyAnimationBinding> {

    private WindowManager manager;
    private int width;
    private int height;
    private float scalex = 1;
    private float scaley = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();
        Log.i("screen", "width:" + width + "height:" + height);
        showContentView();
    }
}
