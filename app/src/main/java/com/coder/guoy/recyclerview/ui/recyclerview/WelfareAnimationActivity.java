package com.coder.guoy.recyclerview.ui.recyclerview;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.ApiHelper;
import com.coder.guoy.recyclerview.api.bean.GankIoDataBean;
import com.coder.guoy.recyclerview.base.MvvmBaseActivityNoTitle;
import com.coder.guoy.recyclerview.databinding.ActivityWelfareBinding;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月19日
 * @Descrpiton:RecyclerView给Item添加滑动时动画
 */
public class WelfareAnimationActivity extends MvvmBaseActivityNoTitle<ActivityWelfareBinding> {

    private List<GankIoDataBean.ResultsBean> mList = new ArrayList<GankIoDataBean.ResultsBean>();
    private GridLayoutManager mLayoutManager;
    private WelfareAnimationAdapter adapter;
    //每次加载条目的数量
    private static int PAGE_COUNT = 40;
    //请求起始页
    private int PAGE = 1;
    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);
        bindingView.refreshlayout.setEnabled(false);
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
     * 获取网络数据
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
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        // 初始化RecyclerView的Adapter
        // 第一个参数为Context
        // 第二个参数为数据，上拉加载的原理就是分页，所以我设置常量PAGE_COUNT=10，即每次加载10个数据
        adapter = new WelfareAnimationAdapter(this, mList);
        mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        bindingView.recyclerview.setLayoutManager(mLayoutManager);
        bindingView.recyclerview.setAdapter(adapter);
        //设置Item增加、移除动画
        bindingView.recyclerview.setItemAnimator(new DefaultItemAnimator());
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
