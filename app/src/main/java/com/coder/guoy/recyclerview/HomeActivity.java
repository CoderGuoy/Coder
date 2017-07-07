package com.coder.guoy.recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.coder.guoy.recyclerview.databinding.ActivityHomeBinding;
import com.coder.guoy.recyclerview.databinding.NavigationHeaderBinding;
import com.coder.guoy.recyclerview.linstener.PerfectClickListener;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.utils.ToastUtil;
import com.coder.guoy.recyclerview.view.statusbar.StatusBarUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding bindingView;
    private HomeAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private String[] model = {"Material Design", "RecyclerView", "CardView", "Customize", "Animation",
            "Design Pattern", "目标1", "目标2", "目标3", "目标4"};
    private String[] describe = {"材料设计", "", "卡片控件", "自定义", "动画",
            "设计模式", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initView();
        initRecyclerView();
        initDrawerlayout();
    }

    private void initView() {
        //设置StatusBar状态栏颜色
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(HomeActivity.this, bindingView.drawerlayout,
                CommonUtils.getColor(R.color.colorTheme));
        findViewById(R.id.fl_title_menu).setOnClickListener(this);

    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        adapter = new HomeAdapter(this, model, describe);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bindingView.homeRecyclerview.setLayoutManager(mLayoutManager);
        bindingView.homeRecyclerview.setAdapter(adapter);
    }

    /**
     * 初始化侧拉菜单
     */
    private void initDrawerlayout() {
        View headerView = bindingView.navigationview.getHeaderView(0);
        NavigationHeaderBinding bind = DataBindingUtil.bind(headerView);
        bind.llNav1.setOnClickListener(listener);
        bind.llNav2.setOnClickListener(listener);
        bind.llNav3.setOnClickListener(listener);
        bind.llNav4.setOnClickListener(listener);
        bind.llNav5.setOnClickListener(listener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_title_menu:// 开启菜单
                bindingView.drawerlayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(final View v) {
            bindingView.drawerlayout.closeDrawer(GravityCompat.START);
            bindingView.drawerlayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (v.getId()) {
                        case R.id.ll_nav_1:
                            ToastUtil.show("1");
                            break;
                        case R.id.ll_nav_2:
                            ToastUtil.show("2");
                            break;
                        case R.id.ll_nav_3:
                            ToastUtil.show("3");
                            break;
                        case R.id.ll_nav_4:
                            ToastUtil.show("4");
                            break;
                        case R.id.ll_nav_5:
                            ToastUtil.show("5");
                            break;
                    }
                }
            }, 260);
        }
    };

    @Override
    public void onBackPressed() {
        if (bindingView.drawerlayout.isDrawerOpen(GravityCompat.START)) {
            bindingView.drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
