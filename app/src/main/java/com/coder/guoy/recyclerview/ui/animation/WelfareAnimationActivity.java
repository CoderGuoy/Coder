package com.coder.guoy.recyclerview.ui.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.ApiHelper;
import com.coder.guoy.recyclerview.api.bean.GankIoDataBean;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityWelfareBinding;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月14日
 * @Descrpiton:RecycleView下拉刷新，上拉加载更多
 */
public class WelfareAnimationActivity extends MvvmBaseActivity<ActivityWelfareBinding> {

    private List<GankIoDataBean.ResultsBean> mList = new ArrayList<GankIoDataBean.ResultsBean>();
    private GridLayoutManager mLayoutManager;
    private WelfareAnimationAdapter adapter;
    //页面可见的最后一个条目
    private int lastVisibleItem = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    //每次加载条目的数量
    private static int PAGE_COUNT = 20;
    //请求起始页
    private int PAGE = 1;
    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);
        initView();
        initNetData();
    }

    private void initView() {
        animation = (AnimationDrawable) bindingView.imageview.getDrawable();
        if (!animation.isRunning()) {
            animation.start();
        }
    }

    /**
     * 首次获取网络数据
     */
    private void initNetData() {
        ApiHelper.getInstance(Constants.GANK_URL).getGankIoDataBean(Constants.FULI, PAGE_COUNT, PAGE)
                .subscribe(new Subscriber<GankIoDataBean>() {
                    @Override
                    public void onNext(GankIoDataBean bean) {
                        bindingView.setGankIoDataBean(bean);
                        mList = bean.getResults();
                    }

                    @Override
                    public void onCompleted() {
                        initRefreshLayout();
                        initRecyclerView();
                        showContentView();
                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
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
                getNetData(1);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bindingView.refreshlayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        // 初始化RecyclerView的Adapter
        // 第一个参数为Context
        // 第二个参数为数据，上拉加载的原理就是分页，所以我设置常量PAGE_COUNT=10，即每次加载10个数据
        // 第三个参数为hasMore，是否有新数据
        adapter = new WelfareAnimationAdapter(this, mList, mList.size() > 0 ? true : false);
        mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
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
                    // 如果没有隐藏footView，那么最后一个条目的位置就比我们的getItemCount少1
                    if (adapter.isFadeTips() == false && lastVisibleItem + 1 == adapter.getItemCount()) {
                        //更新获取数据
                        getNetData(++PAGE);
                    }
                }
            }
        });
    }

    /**
     * 获取网络数据
     *
     * @param page 请求的页码
     */
    private void getNetData(int page) {
        ApiHelper.getInstance(Constants.GANK_URL).getGankIoDataBean(Constants.FULI, PAGE_COUNT, page)
                .subscribe(new Subscriber<GankIoDataBean>() {
                    @Override
                    public void onNext(GankIoDataBean bean) {
                        bindingView.setGankIoDataBean(bean);
                        mList = bean.getResults();
                    }

                    @Override
                    public void onCompleted() {
                        //然后调用updateRecyclerview方法更新RecyclerView
                        updateRecyclerView();
                        showContentView();
                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
                    }
                });
    }

    // 上拉加载时调用的更新RecyclerView的方法
    private void updateRecyclerView() {
        // 获取从fromIndex到toIndex的数据
        List<GankIoDataBean.ResultsBean> list = mList;
        if (list.size() > 0) {
            // 然后传给Adapter，并设置hasMore为true
            adapter.updateList(list, true);
        } else {
            adapter.updateList(null, false);
        }
    }

    @Override
    public void onRefresh() {
        initNetData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (animation.isRunning()) {
            animation.stop();
        }
    }
}
