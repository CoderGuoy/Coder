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

import java.util.ArrayList;
import java.util.List;

import static com.coder.guoy.recyclerview.R.id.textview1;


/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/5/23
 * @Descrpiton:
 */
public class Classification extends LinearLayout {
    private String TAG = "Classification";
    private ImageView icon;
    private TextView title;
    private TextView contentText1, contentText2, contentText3, contentText4;
    private TextView contentText5, contentText6, contentText7, contentText8;
    private LinearLayout contentLayout1, contentLayout2;

    private List<CharSequence> contentList = new ArrayList<CharSequence>();
    private String classTitle;
    private Drawable classIcon;

    //在代码调用的时候使用
    public Classification(Context context) {
        super(context);
        init(context, null);
    }

    //在布局文件中使用的时候调用
    public Classification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    //在布局文件中使用的时候调用，比两个参数的多个样式文件
    public Classification(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.classification, this, true);
        icon = (ImageView) view.findViewById(R.id.icon);
        title = (TextView) view.findViewById(R.id.title);
        contentLayout1 = (LinearLayout) view.findViewById(R.id.content_layout1);
        contentLayout2 = (LinearLayout) view.findViewById(R.id.content_layout2);
        contentText1 = (TextView) view.findViewById(textview1);
        contentText2 = (TextView) view.findViewById(R.id.textview2);
        contentText3 = (TextView) view.findViewById(R.id.textview3);
        contentText4 = (TextView) view.findViewById(R.id.textview4);
        contentText5 = (TextView) view.findViewById(R.id.textview5);
        contentText6 = (TextView) view.findViewById(R.id.textview6);
        contentText7 = (TextView) view.findViewById(R.id.textview7);
        contentText8 = (TextView) view.findViewById(R.id.textview8);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Classification);
        if (typedArray != null) {
            //设置icon
            classIcon = typedArray.getDrawable(R.styleable.Classification_icon);
            if (classIcon == null) {
                //设置默认图标
                icon.setImageResource(R.drawable.classcsjz);
            } else {
                setIcon(classIcon);
            }

            //设置title
            classTitle = typedArray.getString(R.styleable.Classification_title);
            if (classTitle == null) {
                //设置默认标题
                title.setText("请设置标题");
            } else {
                setTitle(classTitle);
            }

            typedArray.recycle();
        }
    }

    /**
     * 设置Title
     *
     * @param classTitle
     */
    public void setTitle(String classTitle) {
        title.setText(classTitle);
    }

    /**
     * 设置Icon
     *
     * @param drawable
     */
    public void setIcon(Drawable drawable) {
        icon.setImageDrawable(drawable);
    }

    public void setList(List<CharSequence> list) {
        //设置内容
        switch (list.size()) {
            case 1:
                showLineOne();
                showTextOne(list);
                break;
            case 2:
                showLineOne();
                showTextOne(list);
                showTextTwo(list);
                break;
            case 3:
                showLineOne();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                break;
            case 4:
                showLineOne();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                showTextFore(list);
                break;
            case 5:
                showLineTwo();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                showTextFore(list);
                showTextFive(list);
                break;
            case 6:
                showLineTwo();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                showTextFore(list);
                showTextFive(list);
                showTextSix(list);
                break;
            case 7:
                showLineTwo();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                showTextFore(list);
                showTextFive(list);
                showTextSix(list);
                showTextSeven(list);
                break;
            case 8:
                showLineTwo();
                showTextOne(list);
                showTextTwo(list);
                showTextThree(list);
                showTextFore(list);
                showTextFive(list);
                showTextSix(list);
                showTextSeven(list);
                showTextEight(list);
                break;
        }
    }

    private void showTextOne(List<CharSequence> list) {
        contentText1.setVisibility(VISIBLE);
        contentText1.setText(list.get(0));
    }

    private void showTextTwo(List<CharSequence> list) {
        contentText2.setVisibility(VISIBLE);
        contentText2.setText(list.get(1));
    }

    private void showTextThree(List<CharSequence> list) {
        contentText3.setVisibility(VISIBLE);
        contentText3.setText(list.get(2));
    }

    private void showTextFore(List<CharSequence> list) {
        contentText4.setVisibility(VISIBLE);
        contentText4.setText(list.get(3));
    }

    private void showTextFive(List<CharSequence> list) {
        contentText5.setVisibility(VISIBLE);
        contentText5.setText(list.get(4));
    }

    private void showTextSix(List<CharSequence> list) {
        contentText6.setVisibility(VISIBLE);
        contentText7.setText(list.get(5));
    }

    private void showTextSeven(List<CharSequence> list) {
        contentText7.setVisibility(VISIBLE);
        contentText7.setText(list.get(6));
    }

    private void showTextEight(List<CharSequence> list) {
        contentText8.setVisibility(VISIBLE);
        contentText8.setText(list.get(7));
    }

    /**
     * 显示内容区域第一行
     */
    private void showLineOne() {
        contentLayout1.setVisibility(VISIBLE);
        contentLayout2.setVisibility(GONE);
    }
    /**
     * 显示内容区域第二行
     */
    private void showLineTwo() {
        contentLayout1.setVisibility(VISIBLE);
        contentLayout2.setVisibility(VISIBLE);
    }


}
