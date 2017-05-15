package com.coder.guoy.recyclerview;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerlayout;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private String[] model = {"RecyclerView", "CardView", "Material Design","3Dtouch","Design Pattern"};
    private int[] image = {R.drawable.model01, R.drawable.model02, R.drawable.model03,R.drawable.model01,R.drawable.model02};

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
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        adapter = new HomeAdapter(this, model, image);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
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
