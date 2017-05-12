package com.coder.guoy.recyclerview.ui.cardview;

import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayCardViewBinding;
/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月12日
 * @Descrpiton:
 */
public class PlayCardView extends MvvmBaseActivity<ActivityPlayCardViewBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_card_view);
        showContentView();
        bindingView.cardviewToolbar.textviewTitle.setText("CardView");
        bindingView.cardviewToolbar.toolbarBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
