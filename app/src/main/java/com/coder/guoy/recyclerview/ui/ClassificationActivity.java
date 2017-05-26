package com.coder.guoy.recyclerview.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.api.ApiHelper;
import com.coder.guoy.recyclerview.api.bean.GankIoDataBean;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityClassificationBinding;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;


public class ClassificationActivity extends MvvmBaseActivity<ActivityClassificationBinding> {

    private List<CharSequence> list = new ArrayList<CharSequence>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        showContentView();
//        getNetData();
        list.add("民族餐厅");
        list.add("有待抚恤");
        list.add("老年优待");
        list.add("适龄入学");
        list.add("残疾康复");
        bindingView.classification.setList(list);
        bindingView.classification.setTitle("教育");
        bindingView.classification.setIcon(getDrawable(R.drawable.classwtyl));
    }

    private void getNetData() {
        ApiHelper.getInstance(Constants.GANK_URL).getGankIoDataBean("Android", 10, 1)
                .subscribe(new Subscriber<GankIoDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GankIoDataBean bean) {
                        bindingView.setWhoBean(bean);
                    }
                });
    }
}
