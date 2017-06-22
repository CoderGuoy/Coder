package com.coder.guoy.recyclerview.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityClassificationBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;
import com.coder.guoy.recyclerview.view.classification.OnContentTextClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:
 * @Descrpiton:自定义组合控件
 */
public class ClassificationActivity extends MvvmBaseActivity<ActivityClassificationBinding> implements OnContentTextClickListener {

    private List<CharSequence> list = new ArrayList<CharSequence>();
    private List<CharSequence> list2 = new ArrayList<CharSequence>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        showContentView();
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        list.add("民族餐厅");
        bindingView.classification.setIcon(getDrawable(R.drawable.classcyzs));
        bindingView.classification.setTitle("教育");
        bindingView.classification.setList(list);
        bindingView.classification.setListener(this);

        list.add("有待抚恤啊");
        bindingView.classification2.setIcon(getDrawable(R.drawable.classmzzj));
        bindingView.classification2.setTitle("医疗");
        bindingView.classification2.setList(list);
        bindingView.classification2.setListener(this);

        list.add("老年优待啊");
        bindingView.classification3.setIcon(getDrawable(R.drawable.classsbjy));
        bindingView.classification3.setTitle("水电");
        bindingView.classification3.setList(list);
        bindingView.classification3.setListener(this);

        list.add("适龄入学");
        bindingView.classification4.setIcon(getDrawable(R.drawable.classwtyl));
        bindingView.classification4.setTitle("水电2");
        bindingView.classification4.setList(list);
        bindingView.classification4.setListener(this);

        list.add("残疾康复");
        list2.add("111");
        list2.add("222");
        list2.add("333");
        list2.add("444");
        list2.add("555");
        list2.add("666");
        list2.add("777");
        bindingView.classification5.setIcon(getDrawable(R.drawable.classcsjz));
        bindingView.classification5.setTitle("水电3");
        bindingView.classification5.setList(list2);
        bindingView.classification5.setListener(this);

        list.add("供电站");
        bindingView.classification6.setIcon(getDrawable(R.drawable.classjdbs));
        bindingView.classification6.setTitle("水电4");
        bindingView.classification6.setList(list);
        bindingView.classification6.setListener(this);

        list.add("供水站");
        bindingView.classification7.setIcon(getDrawable(R.drawable.classjtcx));
        bindingView.classification7.setTitle("水电5");
        bindingView.classification7.setList(list);
        bindingView.classification7.setListener(this);

        list.add("供水站2");
        bindingView.classification8.setIcon(getDrawable(R.drawable.classjtcx));
        bindingView.classification8.setTitle("水电6");
        bindingView.classification8.setList(list);
        bindingView.classification8.setListener(this);
    }

    @Override
    public void onContentTextClick(CharSequence string) {
        ToastUtil.show(string + "");
    }


}
