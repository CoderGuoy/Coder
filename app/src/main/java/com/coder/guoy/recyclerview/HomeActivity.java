package com.coder.guoy.recyclerview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerlayout;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private String[] model = {"Material Design", "RecyclerView", "CardView", "Customize", "Animation",
            "Design Pattern", "目标1", "目标2", "目标3", "目标4"};
    private String[] describe = {"材料设计", "", "卡片控件", "自定义", "动画",
            "设计模式", "", "", "", ""};
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initRecyclerView();
    }

    private void initView() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        recyclerView = (RecyclerView) findViewById(R.id.home_recyclerview);
        //设置StatusBar状态栏颜色
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(HomeActivity.this, drawerlayout,
                CommonUtils.getColor(R.color.colorTheme));
        findViewById(R.id.fl_title_menu).setOnClickListener(this);

        video = (VideoView) findViewById(R.id.videoview);
        video.setVideoPath(Environment.getExternalStorageDirectory().getPath()+"/speed8.mp4");
        video.setMediaController(new MediaController(this));
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        adapter = new HomeAdapter(this, model, describe);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        video.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_title_menu:// 开启菜单
                drawerlayout.openDrawer(GravityCompat.START);
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
