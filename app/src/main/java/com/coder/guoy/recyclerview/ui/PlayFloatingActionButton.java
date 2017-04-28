package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.ApiHelper;
import com.coder.guoy.recyclerview.api.bean.GankIoDataBean;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayFloatingActionButtonBinding;
import com.coder.guoy.recyclerview.ui.animation.WelfareAnimationAdapter;
import com.coder.guoy.recyclerview.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class PlayFloatingActionButton extends MvvmBaseActivity<ActivityPlayFloatingActionButtonBinding> implements View.OnClickListener {

    private List<GankIoDataBean.ResultsBean> mList = new ArrayList<GankIoDataBean.ResultsBean>();
    private GridLayoutManager mLayoutManager;
    //每次加载条目的数量
    private static int PAGE_COUNT = 40;
    //请求起始页
    private int PAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_floating_action_button);
//        initNetData();
        showContentView();
        bindingView.fab.setOnClickListener(this);
    }

    /**
     * 获取网络数据
     */
    private void initNetData() {
        ApiHelper.getInstance(Constants.GANK_URL).getGankIoDataBean(Constants.FULI, PAGE_COUNT, PAGE)
                .subscribe(new Subscriber<GankIoDataBean>() {
                    @Override
                    public void onNext(GankIoDataBean bean) {
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
        mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        bindingView.fabRecyclerview.setLayoutManager(mLayoutManager);
        bindingView.fabRecyclerview.setAdapter(new WelfareAnimationAdapter(this, mList));
    }

    @Override
    public void onClick(View v) {
        ToastUtil.show("被点击");
    }
}
