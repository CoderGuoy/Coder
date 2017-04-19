package com.coder.guoy.recyclerview.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.databinding.ActivityBaseheadMvvmBinding;
import com.coder.guoy.recyclerview.linstener.PerfectClickListener;
import com.coder.guoy.recyclerview.utils.CommonUtils;
import com.coder.guoy.recyclerview.utils.StatusBarUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @Version:1.0
 * @Author:Guoy
 * @CreateTime:2017年4月7日
 * @Descrpiton:MVVM模式的BaseActivity
 * @UpDateAuthor:
 * @UpDateTime:
 * @UpDataWhat:
 */

public class MvvmBaseHeadActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    protected SV bindingView;// 布局view
    private LinearLayout llProgressBar;//努力加载中...
    private View refresh;//加载失败
    private ActivityBaseheadMvvmBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("baseactivity", "baseactivity" +getClass().getSimpleName());
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_basehead_mvvm, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        //content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        overridePendingTransition(R.anim.slide_left_in,R.anim.slide_left_out);

        // 设置透明状态栏
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
        setTitleBar();
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
    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 设置titlebar
     */
    protected void setTitleBar() {
        mBaseBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backFragment();
            }
        });

    }

    /**
     * 返回键和左上角的返回图标返回效果一致
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            backFragment();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setTitle(CharSequence text) {
        mBaseBinding.textviewTitle.setText(text);
    }

    /**
     * fragment返回
     */
    public void backFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {//这里是取出我们返回栈存在Fragment的个数
            finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    /**
     * 带动画的返回
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_in,R.anim.slide_right_out);
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

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    public void removeSubscription() {
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 添加fragment
     * @param addId
     * @param fragment
     */
    protected void addFragment(int addId, MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(addId, fragment).addToBackStack(null).commit();
    }

    protected void replaceFragment(int addId, MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(addId, fragment).commit();
    }
    protected void removeFragment(MvvmBaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
