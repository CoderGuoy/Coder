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
    private TextView contentText1, contentText2, contentText3, contentText4, contentText5;
    private TextView contentText6, contentText7, contentText8, contentText9, contentText10;
    private LinearLayout contentLayout1, contentLayout2;
    private List<CharSequence> list = new ArrayList<CharSequence>();
    private String classTitle;
    private Drawable classIcon;


    public Classification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

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
                icon.setImageDrawable(classIcon);
            }

            //设置title
            classTitle = typedArray.getString(R.styleable.Classification_title);
            if (classTitle.isEmpty()) {
                //设置默认标题
                title.setText("请设置标题");
            } else {
                title.setText(classTitle);
            }

//            Log.i(TAG, list.size() + "");
//            //设置内容
//            switch (list.size()) {
//                case 1:
//                    showLineOne();
//                    showTextOne();
//                    break;
//                case 2:
//                    showLineOne();
//                    showTextOne();
//                    showTextTwo();
//                    break;
//                case 3:
//                    showLineOne();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    break;
//                case 4:
//                    showLineOne();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    showTextFore();
//                    break;
//                case 5:
//                    showLineTwo();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    showTextFore();
//                    showTextFive();
//                    break;
//                case 6:
//                    showLineTwo();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    showTextFore();
//                    showTextFive();
//                    showTextSix();
//                    break;
//                case 7:
//                    showLineTwo();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    showTextFore();
//                    showTextFive();
//                    showTextSix();
//                    showTextSeven();
//                    break;
//                case 8:
//                    showLineTwo();
//                    showTextOne();
//                    showTextTwo();
//                    showTextThree();
//                    showTextFore();
//                    showTextFive();
//                    showTextSix();
//                    showTextSeven();
//                    showTextEight();
//                    break;
//            }


            typedArray.recycle();
        }
    }

    private void showTextOne() {
        contentText1.setVisibility(VISIBLE);
        contentText1.setText(list.get(0));
    }

    private void showTextTwo() {
        contentText2.setVisibility(VISIBLE);
        contentText2.setText(list.get(1));
    }

    private void showTextThree() {
        contentText3.setVisibility(VISIBLE);
        contentText3.setText(list.get(2));
    }

    private void showTextFore() {
        contentText4.setVisibility(VISIBLE);
        contentText4.setText(list.get(3));
    }

    private void showTextFive() {
        contentText5.setVisibility(VISIBLE);
        contentText5.setText(list.get(4));
    }

    private void showTextSix() {
        contentText6.setVisibility(VISIBLE);
        contentText7.setText(list.get(5));
    }

    private void showTextSeven() {
        contentText7.setVisibility(VISIBLE);
        contentText7.setText(list.get(6));
    }

    private void showTextEight() {
        contentText8.setVisibility(VISIBLE);
        contentText8.setText(list.get(7));
    }

    private void showLineOne() {
        contentLayout1.setVisibility(VISIBLE);
        contentLayout2.setVisibility(GONE);
    }

    private void showLineTwo() {
        contentLayout1.setVisibility(VISIBLE);
        contentLayout2.setVisibility(VISIBLE);
    }

    public List<CharSequence> getList() {
        return list;
    }

    public void setList(List<CharSequence> list) {
        this.list = list;
    }

    public void setTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public void setIcon(Drawable classIcon) {
        this.classIcon = classIcon;
    }

}
