package com.coder.guoy.recyclerview.ui.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.coder.guoy.recyclerview.R;

import java.util.ArrayList;
import java.util.List;


public class PlayTabLayout extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        List<String> mList = new ArrayList<String>();
        for (int i = 1; i <= 8; i++) {
            mList.add("Tab" + i);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mList));
        //setupWithViewPagerb必须在viewpager之后
        tabLayout.setupWithViewPager(viewPager);
    }
}
