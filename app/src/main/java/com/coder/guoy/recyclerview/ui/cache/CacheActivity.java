package com.coder.guoy.recyclerview.ui.cache;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.bean.ImageBean;
import com.coder.guoy.recyclerview.databinding.ActivityCacheBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;

import java.util.List;

import rx.Observer;
import rx.Subscription;

public class CacheActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCacheBinding binding;
    private CacheAdapter adapter;
    private long startTime;
    protected Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cache);
        transparentStatusBar();
        initRecyclerView(binding.recyclerviewModel2);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        //最新
        getNetData(Constants.ZMBZ);
    }

    // TODO: 透明状态栏
    private void transparentStatusBar() {
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    //TODO: 获取网络数据
    private void getNetData(final String url) {
        startTime = System.currentTimeMillis();
        unsubscribe();
        subscription = Data.getInstance().subscribeData(new Observer<List<ImageBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("cache_onError", e.toString());
            }

            @Override
            public void onNext(List<ImageBean> imageBeen) {
                int loadTime = (int) (System.currentTimeMillis() - startTime);
                Log.i("cache_onNext", loadTime + "ms");
                adapter.setNewData(imageBeen);
            }
        }, url);
    }

    // TODO: 图片列表
    private void initRecyclerView(RecyclerView recyclerView) {
        adapter = new CacheAdapter(this);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                Data.getInstance().clearMemoryCache();
                ToastUtil.show("内存缓存已清空");
                adapter.removeItems(null);
                break;
            case R.id.btn_2:
                Data.getInstance().clearMemoryAndDiskCache();
                ToastUtil.show("内存缓存和磁盘缓存已清空");
                adapter.removeItems(null);
                break;
            case R.id.btn_3:
                getNetData(Constants.ZMBZ);
                break;
        }
    }
}