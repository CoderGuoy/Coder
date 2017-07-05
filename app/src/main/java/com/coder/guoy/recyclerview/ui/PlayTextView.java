package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayTextViewBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月2日
 * @Descrpiton:自定义文本
 */
public class PlayTextView extends MvvmBaseActivity<ActivityPlayTextViewBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_text_view);
        showContentView();
        setTitle("自定义文本");
        bindingView.textRect.setText("矩形文本");
        bindingView.textShader.setText("Android Shader Text");
    }
}
