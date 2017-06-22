package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayShapeBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月8日
 * @Descrpiton:自定义图形
 */
public class PlayShape extends MvvmBaseActivity<ActivityPlayShapeBinding> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_shape);
        showContentView();
    }

}
