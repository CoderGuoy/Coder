package com.coder.guoy.recyclerview.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.coder.guoy.recyclerview.R;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 * @UpDateAuthor:
 * @UpDateTime:
 * @UpDataWhat:
 */
public class GlideUtils {

    public static void setImage(Context context, String url, ImageView imageview) {
        Glide.with(context).load(url)
                .placeholder(R.drawable.app_loading0)   //加载中显示的图片
                .error(R.drawable.app_loading0)         //加载失败显示的图片
                .fallback(R.drawable.app_loading0)             //默认图片
                .crossFade()                            //渐显动画
                .fitCenter()
                .into(imageview);


    }


}
