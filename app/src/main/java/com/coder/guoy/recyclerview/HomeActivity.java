package com.coder.guoy.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.view.View;

import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityHomeBinding;
import com.coder.guoy.recyclerview.ui.animation.WelfareAnimationActivity;
import com.coder.guoy.recyclerview.ui.sample.SampleActivity;
import com.coder.guoy.recyclerview.ui.welfare.WelfareActivity;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.utils.StatusBarUtils;

public class HomeActivity extends MvvmBaseActivity<ActivityHomeBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showContentView();
        // 设置透明状态栏
        StatusBarUtils.setColor(this, CommonUtils.getColor(R.color.colorTheme), 0);
        bindingView.flTitleMenu.setOnClickListener(this);
        bindingView.button1.setOnClickListener(this);
        bindingView.button2.setOnClickListener(this);
        bindingView.button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_title_menu:// 开启菜单
                bindingView.drawerlayout.openDrawer(GravityCompat.START);
                break;
            case R.id.button1:
                startActivity(new Intent(HomeActivity.this, SampleActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(HomeActivity.this, WelfareActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(HomeActivity.this, WelfareAnimationActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (bindingView.drawerlayout.isDrawerOpen(GravityCompat.START)) {
            bindingView.drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
