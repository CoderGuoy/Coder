package com.coder.guoy.recyclerview.ui.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayBottomSheetDialogBinding;

public class PlayBottomSheetDialog extends MvvmBaseActivity<ActivityPlayBottomSheetDialogBinding> implements View.OnClickListener {

    private BottomSheetDialog bsd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bottom_sheet_dialog);
        showContentView();
        bindingView.bottomsheet.textviewTitle.setText("BottomSheetDialog");
        bindingView.bottomsheet.toolbarBack.setOnClickListener(this);
        bindingView.btnBsd1.setOnClickListener(this);
        bindingView.btnBsd2.setOnClickListener(this);
        initBSD();
    }

    private void initBSD() {
        bsd1 = new BottomSheetDialog(this);
        bsd1.setContentView(R.layout.toolbar);
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
        }
    }
}
