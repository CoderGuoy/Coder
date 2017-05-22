package com.coder.guoy.recyclerview.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017/5/22
 * @Descrpiton:
 */
public class Classification extends ViewGroup {

    private String title;
    private int titleColor;
    private Drawable drawable;
    private String contentTitle;
    private int contentTitleColor;
    private ImageView titleImageView;
    private TextView titleText;

    public Classification(Context context) {
        super(context);
    }

    public Classification(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Classification);
        title = ta.getString(R.styleable.Classification_title);
        titleColor = ta.getColor(R.styleable.Classification_title_color, 0);
        drawable = ta.getDrawable(R.styleable.Classification_icon);
        contentTitle = ta.getString(R.styleable.Classification_content_title);
        contentTitleColor = ta.getColor(R.styleable.Classification_content_title_color, 0);

        titleImageView = new ImageView(context);
        titleText = new TextView(context);
        //为创建的组件元素赋值
        titleImageView.setImageDrawable(drawable);

    }

    public Classification(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
