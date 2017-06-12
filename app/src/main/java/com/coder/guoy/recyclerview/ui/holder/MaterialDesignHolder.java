package com.coder.guoy.recyclerview.ui.holder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityMaterialDesignHolderBinding;
import com.coder.guoy.recyclerview.ui.PlayTouchFeedback;
import com.coder.guoy.recyclerview.ui.animation.DrawableAnimation;
import com.coder.guoy.recyclerview.ui.animation.PropertyAnimation;
import com.coder.guoy.recyclerview.ui.animation.ViewAnimation;
import com.coder.guoy.recyclerview.ui.bottomsheet.PlayBottomSheetDialog;
import com.coder.guoy.recyclerview.ui.coordinator.PlayCoordinatorBehavior;
import com.coder.guoy.recyclerview.ui.coordinator.PlayCoordinatorLayout;
import com.coder.guoy.recyclerview.ui.coordinator.PlayCoordinatorToolbar;
import com.coder.guoy.recyclerview.ui.PlayFloatingActionButton;
import com.coder.guoy.recyclerview.ui.PlayStatusBar;
import com.coder.guoy.recyclerview.ui.tablayout.PlayTabLayout;
import com.coder.guoy.recyclerview.ui.PlayTextInputLayout;

/**
 * @Version:
 * @Author:
 * @CreateTime:2017年5月11日
 * @Descrpiton:
 */
public class MaterialDesignHolder extends MvvmBaseActivity<ActivityMaterialDesignHolderBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_holder);
        showContentView();
        bindingView.materialdesignHolder.textviewTitle.setText("Material Design");
        bindingView.materialdesignHolder.toolbarBack.setOnClickListener(this);
        bindingView.button5.setOnClickListener(this);
        bindingView.button6.setOnClickListener(this);
        bindingView.button7.setOnClickListener(this);
        bindingView.button8.setOnClickListener(this);
        bindingView.button9.setOnClickListener(this);
        bindingView.button10.setOnClickListener(this);
        bindingView.button11.setOnClickListener(this);
        bindingView.buttonBsd.setOnClickListener(this);
        bindingView.btnFeedfack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.button5:
                startActivity(new Intent(MaterialDesignHolder.this, PlayCoordinatorToolbar.class));
                break;
            case R.id.button6:
                startActivity(new Intent(MaterialDesignHolder.this, PlayStatusBar.class));
                break;
            case R.id.button7:
                startActivity(new Intent(MaterialDesignHolder.this, PlayTabLayout.class));
                break;
            case R.id.button8:
                startActivity(new Intent(MaterialDesignHolder.this, PlayTextInputLayout.class));
                break;
            case R.id.button9:
                startActivity(new Intent(MaterialDesignHolder.this, PlayFloatingActionButton.class));
                break;
            case R.id.button10:
                startActivity(new Intent(MaterialDesignHolder.this, PlayCoordinatorLayout.class));
                break;
            case R.id.button11:
                startActivity(new Intent(MaterialDesignHolder.this, PlayCoordinatorBehavior.class));
                break;
            case R.id.button12:
                startActivity(new Intent(MaterialDesignHolder.this, DrawableAnimation.class));
                break;
            case R.id.button13:
                startActivity(new Intent(MaterialDesignHolder.this, ViewAnimation.class));
                break;
            case R.id.button14:
                startActivity(new Intent(MaterialDesignHolder.this, PropertyAnimation.class));
                break;
            case R.id.button_bsd:
                startActivity(new Intent(MaterialDesignHolder.this, PlayBottomSheetDialog.class));
                break;
            case R.id.btn_feedfack:
                startActivity(new Intent(MaterialDesignHolder.this, PlayTouchFeedback.class));
                break;
        }
    }
}
