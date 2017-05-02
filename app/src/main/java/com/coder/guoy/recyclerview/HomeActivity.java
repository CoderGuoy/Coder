package com.coder.guoy.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.coder.guoy.recyclerview.ui.coordinator.PlayCoordinatorLayout;
import com.coder.guoy.recyclerview.ui.floatingactionbutton.PlayFloatingActionButton;
import com.coder.guoy.recyclerview.ui.textinputlayout.PlayTextInputLayout;
import com.coder.guoy.recyclerview.ui.statusbar.PlayStatusBar;
import com.coder.guoy.recyclerview.ui.coordinator.PlayCoordinatorToolbar;
import com.coder.guoy.recyclerview.ui.animation.WelfareAnimationActivity;
import com.coder.guoy.recyclerview.ui.sample.SampleActivity;
import com.coder.guoy.recyclerview.ui.tablayout.PlayTabLayout;
import com.coder.guoy.recyclerview.ui.tagcloud.TagCloudActivity;
import com.coder.guoy.recyclerview.ui.welfare.WelfareActivity;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(HomeActivity.this, drawerlayout,
                CommonUtils.getColor(R.color.colorTheme));
        findViewById(R.id.fl_title_menu).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_title_menu:// 开启菜单
                drawerlayout.openDrawer(GravityCompat.START);
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
            case R.id.button4:
                startActivity(new Intent(HomeActivity.this, TagCloudActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(HomeActivity.this, PlayCoordinatorToolbar.class));
                break;
            case R.id.button6:
                startActivity(new Intent(HomeActivity.this, PlayStatusBar.class));
                break;
            case R.id.button7:
                startActivity(new Intent(HomeActivity.this, PlayTabLayout.class));
                break;
            case R.id.button8:
                startActivity(new Intent(HomeActivity.this, PlayTextInputLayout.class));
                break;
            case R.id.button9:
                startActivity(new Intent(HomeActivity.this, PlayFloatingActionButton.class));
                break;
            case R.id.button10:
                startActivity(new Intent(HomeActivity.this, PlayCoordinatorLayout.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
