package com.coder.guoy.recyclerview.ui;

import android.os.Bundle;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.base.MvvmBaseActivity;
import com.coder.guoy.recyclerview.databinding.ActivityPlayMusicBinding;
/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年6月5日
 * @Descrpiton:自定义条形图
 */
public class PlayMusic extends MvvmBaseActivity<ActivityPlayMusicBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        showContentView();
        setTitle("自定义条形图");

    }
}
