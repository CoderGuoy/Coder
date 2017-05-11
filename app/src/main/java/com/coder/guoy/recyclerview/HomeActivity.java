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
    private String[] model = {"RecyclerView", "CardView", "Material Design","3Dtouch"};
    private int[] image = {R.drawable.mode01, R.drawable.model02, R.drawable.model03,R.drawable.mode01};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        recyclerView = (RecyclerView) findViewById(R.id.home_recyclerview);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(HomeActivity.this, drawerlayout,
                CommonUtils.getColor(R.color.colorTheme));
        findViewById(R.id.fl_title_menu).setOnClickListener(this);

        adapter = new HomeAdapter(this, model, image);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

//        findViewById(R.id.button1).setOnClickListener(this);
//        findViewById(R.id.button2).setOnClickListener(this);
//        findViewById(R.id.button3).setOnClickListener(this);
//        findViewById(R.id.button4).setOnClickListener(this);
//        findViewById(R.id.button5).setOnClickListener(this);
//        findViewById(R.id.button6).setOnClickListener(this);
//        findViewById(R.id.button7).setOnClickListener(this);
//        findViewById(R.id.button8).setOnClickListener(this);
//        findViewById(R.id.button9).setOnClickListener(this);
//        findViewById(R.id.button10).setOnClickListener(this);
//        findViewById(R.id.button11).setOnClickListener(this);
//        findViewById(R.id.button12).setOnClickListener(this);
//        findViewById(R.id.button13).setOnClickListener(this);
//        findViewById(R.id.button14).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_title_menu:// 开启菜单
                drawerlayout.openDrawer(GravityCompat.START);
                break;

//            case R.id.button4:
//                startActivity(new Intent(HomeActivity.this, TagCloudActivity.class));
//                break;
//            case R.id.button5:
//                startActivity(new Intent(HomeActivity.this, PlayCoordinatorToolbar.class));
//                break;
//            case R.id.button6:
//                startActivity(new Intent(HomeActivity.this, PlayStatusBar.class));
//                break;
//            case R.id.button7:
//                startActivity(new Intent(HomeActivity.this, PlayTabLayout.class));
//                break;
//            case R.id.button8:
//                startActivity(new Intent(HomeActivity.this, PlayTextInputLayout.class));
//                break;
//            case R.id.button9:
//                startActivity(new Intent(HomeActivity.this, PlayFloatingActionButton.class));
//                break;
//            case R.id.button10:
//                startActivity(new Intent(HomeActivity.this, PlayCoordinatorLayout.class));
//                break;
//            case R.id.button11:
//                startActivity(new Intent(HomeActivity.this, PlayCoordinatorBehavior.class));
//                break;
//            case R.id.button12:
//                startActivity(new Intent(HomeActivity.this, DrawableAnimation.class));
//                break;
//            case R.id.button13:
//                startActivity(new Intent(HomeActivity.this, ViewAnimation.class));
//                break;
//            case R.id.button14:
//                startActivity(new Intent(HomeActivity.this, PropertyAnimation.class));
//                break;
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
