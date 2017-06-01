package com.coder.guoy.recyclerview.ui.holder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityDesignPatternHolderBinding;
import com.coder.guoy.recyclerview.designpattern.StrategyDesign;
/**
 * @Version:
 * @Author:
 * @CreateTime:2017年6月1日
 * @Descrpiton:
 */
public class DesignPatternHolder extends MvvmBaseActivity<ActivityDesignPatternHolderBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern_holder);
        showContentView();
        bindingView.designPattern.textviewTitle.setText("Design Pattern|设计模式");
        bindingView.designPattern.toolbarBack.setOnClickListener(this);
        bindingView.btnStragegy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_stragegy:
                startActivity(new Intent(DesignPatternHolder.this, StrategyDesign.class));
                break;
        }
    }
}
