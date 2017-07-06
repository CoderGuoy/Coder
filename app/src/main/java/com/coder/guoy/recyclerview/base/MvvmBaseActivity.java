package com.coder.guoy.recyclerview.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.databinding.ActivityBaseMvvmBinding;
import com.coder.guoy.recyclerview.linstener.PerfectClickListener;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.utils.StatusBarUtils;

/**
 * @Version:1.0
 * @Author:Guoy
 * @CreateTime:2017年4月7日
 * @Descrpiton:MVVM模式的BaseActivity
 * @UpDateAuthor:
 * @UpDateTime:
 * @UpDataWhat:
 */

public class MvvmBaseActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    protected SV bindingView;// 布局view
    private LinearLayout llProgressBar;//努力加载中...
    private View refresh;//加载失败
    private ActivityBaseMvvmBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base_mvvm, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        //content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        // 设置状态栏颜色
        StatusBarUtils.setColor(this, CommonUtils.getColor(R.color.colorTheme), 0);
        llProgressBar = getView(R.id.ll_progress_bar);
        refresh = getView(R.id.ll_error_refresh);
        ImageView img = getView(R.id.img_progress);

        // 加载动画
        mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        // 默认进入页面就开启动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        setToolBar();
        // 点击加载失败布局
        refresh.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });
        bindingView.getRoot().setVisibility(View.GONE);
    }

    /**
     * 设置ToolBar的返回
     */
    private void setToolBar() {
        mBaseBinding.toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        mBaseBinding.textviewTitle.setText(title);
    }

    /**
     * 设置整个ToolBar是否显示
     * @param visible
     */
    public void setToolbarVisible(int visible){
        mBaseBinding.toolbar.setVisibility(visible);
    }

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 失败后点击刷新
     */
    protected void onRefresh() {

    }

    /**
     * 显示进度条
     */
    protected void showLoading() {
        if (llProgressBar.getVisibility() != View.VISIBLE) {
            llProgressBar.setVisibility(View.VISIBLE);
        }
        // 开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.VISIBLE) {
            refresh.setVisibility(View.VISIBLE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }

    /**
     * 添加fragment
     *
     * @param addId
     * @param fragment
     */
    protected void addFragment(int addId, MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().add(addId, fragment).commit();
    }

    protected void replaceFragment(int addId, MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(addId, fragment).commit();
    }

    protected void removeFragment(MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
