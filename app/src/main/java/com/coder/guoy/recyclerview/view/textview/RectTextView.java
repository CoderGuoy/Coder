package com.coder.guoy.recyclerview.view.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.coder.guoy.recyclerview.R;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/6/2
 * @Descrpiton:
 */
public class RectTextView extends AppCompatTextView {
    public RectTextView(Context context) {
        super(context);
    }

    public RectTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(R.color.red));
        mPaint1.setStyle(Paint.Style.FILL);
        Paint mPaint2 = new Paint();
        mPaint2.setColor(getResources().getColor(R.color.yello));
        mPaint2.setStyle(Paint.Style.FILL);

        //外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10,0);
        //父类完成的方法，绘制文本
        super.onDraw(canvas);
        canvas.restore();
    }
}
