package com.coder.guoy.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityHomeBinding;
import com.coder.guoy.recyclerview.ui.sample.SampleActivity;
import com.coder.guoy.recyclerview.ui.welfare.WelfareActivity;

public class HomeActivity extends MvvmBaseActivity<ActivityHomeBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showContentView();
        bindingView.button1.setOnClickListener(this);
        bindingView.button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(HomeActivity.this, SampleActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(HomeActivity.this, WelfareActivity.class));
                break;
        }
    }
}
