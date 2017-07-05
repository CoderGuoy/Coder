package com.coder.guoy.recyclerview.ui.recyclerview;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivityNoTitle;
import com.coder.guoy.recyclerview.databinding.ActivitySampleBinding;

import java.util.ArrayList;
import java.util.List;
/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月17日
 * @Descrpiton:RecyclerView实现下拉刷新，上拉加载
 */
public class SampleActivity extends MvvmBaseActivityNoTitle<ActivitySampleBinding> {

    private List<String> mList = new ArrayList<String>();
    private LinearLayoutManager mLayoutManager;
    private SampleAdapter adapter;
    //页面可见的最后一个条目
    private int lastVisibleItem = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    //每次加载条目的数量
    private static int PAGE_COUNT = 10;
    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        showContentView();
        initView();
        initNetData();
        initRecyclerView();
        initRefreshLayout();
    }

    private void initView() {
        animation = (AnimationDrawable) bindingView.imageviewSample.getDrawable();
        if (!animation.isRunning()) {
            animation.start();
        }
    }

    /**
     * 获取数据
     */
    private void initNetData() {
        for (int i = 0; i < 40; i++) {
            mList.add("Recycler条目:" + i);
        }
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        // 初始化RecyclerView的Adapter
        // 第一个参数为Context
        // 第二个参数为数据，上拉加载的原理就是分页，所以我设置常量PAGE_COUNT=10，即每次加载10个数据
        // 第三个参数为hasMore，是否有新数据
        adapter = new SampleAdapter(this, getDatas(0, PAGE_COUNT), getDatas(0, PAGE_COUNT).size() > 0 ? true : false);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bindingView.recyclerview.setLayoutManager(mLayoutManager);
        bindingView.recyclerview.setAdapter(adapter);
        //设置Item增加、移除动画
        bindingView.recyclerview.setItemAnimator(new DefaultItemAnimator());
        // 实现上拉加载重要步骤，设置滑动监听器，RecyclerView自带的ScrollListener
        bindingView.recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 在滑动完成后，拿到最后一个可见的item的位置
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 在newState为滑到底部时
                Log.i("newState", newState + "");
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.i("newState", newState + "进入后");
                    // 如果没有隐藏footView，那么最后一个条就比我们的getItemCount少1
                    if (adapter.isFadeTips() == false && lastVisibleItem + 1 == adapter.getItemCount()) {
                        //更新获取数据
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                updateRecyclerView(adapter.getRealLastPosition(), adapter.getRealLastPosition() + PAGE_COUNT);
                            }
                        }, 500);
                    }
                }
            }
        });
    }


    /**
     * 初始化下拉刷新
     */
    private void initRefreshLayout() {
        bindingView.refreshlayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        bindingView.refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bindingView.refreshlayout.setRefreshing(true);
                adapter.resetDatas();
                updateRecyclerView(0, PAGE_COUNT);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bindingView.refreshlayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    // 上拉加载时调用的更新RecyclerView的方法
    private void updateRecyclerView(int fromIndex, int toIndex) {
        // 获取从fromIndex到toIndex的数据
        List<String> newDatas = getDatas(fromIndex, toIndex);
        if (newDatas.size() > 0) {
            // 然后传给Adapter，并设置hasMore为true
            adapter.updateList(newDatas, true);
        } else {
            adapter.updateList(null, false);
        }
    }

    //获取集合内制定范围的集合
    private List<String> getDatas(final int firstIndex, final int lastIndex) {
        List<String> resList = new ArrayList<>();
        for (int i = firstIndex; i < lastIndex; i++) {
            if (i < mList.size()) {
                resList.add(mList.get(i));
            }
        }
        return resList;
    }

}
