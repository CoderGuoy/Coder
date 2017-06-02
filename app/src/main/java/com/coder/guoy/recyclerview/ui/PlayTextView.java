package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayTextViewBinding;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月2日
 * @Descrpiton:
 */
public class PlayTextView extends MvvmBaseActivity<ActivityPlayTextViewBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_text_view);
        showContentView();
        bindingView.textview.textviewTitle.setText("自定义文本");
        bindingView.textview.toolbarBack.setOnClickListener(this);
        bindingView.textRect.setText("矩形文本");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
        }
    }
}
