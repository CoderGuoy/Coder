package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayTextInputLayoutBinding;
import com.coder.guoy.recyclerview.utils.ToastUtil;

public class PlayTextInputLayout extends MvvmBaseActivity<ActivityPlayTextInputLayoutBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_text_input_layout);
        showContentView();
        bindingView.back.setOnClickListener(this);
        bindingView.btnLogin.setOnClickListener(this);
        bindingView.textUsername.setHint("用户名/Email/手机号");
        bindingView.textPassword.setHint("密码");
        bindingView.edittextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username();
            }
        });
        bindingView.edittextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password();
            }
        });
    }

    private boolean username() {
        if (TextUtils.isEmpty(bindingView.edittextUsername.getText())) {
            bindingView.textUsername.setError("用户名/Email/手机号不能为空");
            return false;
        } else {
            bindingView.textUsername.setError(null);
        }
        return true;
    }

    private boolean password() {
        if (TextUtils.isEmpty(bindingView.edittextPassword.getText())) {
            bindingView.textPassword.setError("密码不能为空");
            return false;
        } else {
            bindingView.textPassword.setError(null);
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_login:
                if (username() && password()) {
                    finish();
                    ToastUtil.show("登录成功");
                }
                break;
        }
    }

}
