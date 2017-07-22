package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityHometestBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;
import com.coder.guoy.recyclerview.view.alipay.ItemCallBackListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/7/22
 * @Descrpiton:仿支付宝全部小应用
 */
public class ClassificationAdapterActivity extends MvvmBaseActivity<ActivityHometestBinding> implements ItemCallBackListener {

    private List<String> list = new ArrayList<String>();
    private List<List> contentList = new ArrayList<List>();
    private List<String> contentList1 = new ArrayList<String>();
    private List<String> contentList2 = new ArrayList<String>();
    private List<String> contentList3 = new ArrayList<String>();
    private List<String> contentList4 = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometest);
        showContentView();
        setToolbarVisible(View.GONE);
        initView();
    }

    private void initView() {
        list.add("常用应用");
        list.add("管理决策");
        list.add("民生大数据");
        list.add("办事服务管理");

        contentList4.add("数据决策");
        contentList4.add("共享开放");
        contentList4.add("数据统计");
        contentList4.add("精准查询");
        contentList4.add("采集维护");
        contentList4.add("服务管理");

        contentList1.add("数据决策");
        contentList1.add("共享开放");

        contentList2.add("数据统计");
        contentList2.add("精准查询");
        contentList2.add("采集维护");

        contentList3.add("办事管理");
        contentList3.add("我的审批");
        contentList3.add("服务管理");
        contentList3.add("社事网络");
        contentList3.add("民政互动");
        contentList3.add("测试数据");
        contentList3.add("测试数据");
        contentList3.add("测试数据");
        contentList3.add("测试数据");
        contentList3.add("测试数据");
        contentList3.add("测试数据");
        contentList3.add("测试数据");

        contentList.add(contentList4);
        contentList.add(contentList1);
        contentList.add(contentList2);
        contentList.add(contentList3);
        bindingView.classHome.setList(list, contentList);
        bindingView.classHome.setItemCallBackListener(this);
    }

    @Override
    public void itemOnClick(int position, CharSequence text) {
        ToastUtil.show(position + ";" + text);
        switch (text.toString()) {
            case "数据决策":
                ToastUtil.show("数据决策");
                break;
            case "共享开放":
                ToastUtil.show("共享开放");
                break;
            case "数据统计":
                ToastUtil.show("数据统计");
                break;
            case "精准查询":
                ToastUtil.show("精准查询");
                break;
            case "采集维护":
                ToastUtil.show("采集维护");
                break;
            case "办事管理":
                ToastUtil.show("办事管理");
                break;
            case "我的审批":
                ToastUtil.show("我的审批");
                break;
            case "服务管理":
                ToastUtil.show("服务管理");
                break;
            case "社事网络":
                ToastUtil.show("社事网络");
                break;
            case "民政互动":
                ToastUtil.show("民政互动");
                break;
        }
    }
}
