package com.coder.guoy.recyclerview.ui.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayBottomSheetDialogBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayBottomSheetDialog extends MvvmBaseActivity<ActivityPlayBottomSheetDialogBinding> implements View.OnClickListener {

    private BottomSheetDialog bsd1;
    private BottomSheetDialog bsd2;
    private BottomDialogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bottom_sheet_dialog);
        showContentView();
        bindingView.bottomsheet.textviewTitle.setText("BottomSheetDialog");
        bindingView.bottomsheet.toolbarBack.setOnClickListener(this);
        bindingView.btnBsd1.setOnClickListener(this);
        bindingView.btnBsd2.setOnClickListener(this);
        initView();
    }

    private void initView() {
        View view = View.inflate(this, R.layout.bottom_dialog, null);
        ImageView man = (ImageView) view.findViewById(R.id.image_man);
        ImageView women = (ImageView) view.findViewById(R.id.image_women);
        man.setOnClickListener(this);
        women.setOnClickListener(this);

        bsd1 = new BottomSheetDialog(this);
        bsd1.setContentView(view);
        bsd1.setCanceledOnTouchOutside(false);

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            list.add("" + i);
        }

        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_recycler, null);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BottomDialogAdapter(this, list);
        recyclerView.setAdapter(adapter);

        bsd2 = new BottomSheetDialog(this);
        bsd2.setContentView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_bsd1:
                bsd1.show();
                break;
            case R.id.btn_bsd2:
                bsd2.show();
                break;
            case R.id.image_man:
                ToastUtil.show("男");
                bsd1.dismiss();
                break;
            case R.id.image_women:
                ToastUtil.show("女");
                bsd1.dismiss();
                break;
        }
    }
}
