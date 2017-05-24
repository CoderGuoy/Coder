package com.coder.guoy.recyclerview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;


/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/5/23
 * @Descrpiton:
 */
public class Classification extends LinearLayout {

    private ImageView icon;
    private TextView title;
    private Drawable ClassIcon;
    private String ClassTitle;

    public Classification(Context context) {
        super(context);
    }

    public Classification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Classification(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.classification, this, true);
        icon = (ImageView) view.findViewById(R.id.icon);
        title = (TextView) view.findViewById(R.id.title);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Classification);
        if (ta != null) {
            //设置icon
            ClassIcon = ta.getDrawable(R.styleable.Classification_icon);
            icon.setImageDrawable(ClassIcon);

            //设置title
            ClassTitle = ta.getString(R.styleable.Classification_title);
            title.setText(ClassTitle);
            ta.recycle();
        }
    }


}
