package com.coder.guoy.recyclerview.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.coder.guoy.recyclerview.R;

import java.util.ArrayList;
import java.util.List;


public class ClassificationActivity extends AppCompatActivity {

    private List<CharSequence> list = new ArrayList<CharSequence>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        Classification cf = (Classification) findViewById(R.id.classification);
//        list.add("民族餐厅");
//        list.add("有待抚恤");
//        list.add("老年优待");
//        list.add("适龄入学");
//        list.add("残疾康复");
//        cf.setList(list);
//        cf.setTitle("街道办事");
//        cf.setIcon(getDrawable(R.drawable.classcyzs));
    }
}
