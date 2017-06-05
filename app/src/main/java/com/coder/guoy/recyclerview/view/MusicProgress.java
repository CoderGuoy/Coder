package com.coder.guoy.recyclerview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/6/5
 * @Descrpiton:
 */
public class MusicProgress extends View {
    private double mRandom;
    private Paint mPaint1;
    private int mRectHeight;//矩形的高度
    private int mRectWidth = 100;//矩形的宽度
    private float mCurrentHeight;
    private int offset = 5;//两个矩形之间的间距
    private LinearGradient mLinearGradient;

    public MusicProgress(Context context) {
        super(context);
    }

    public MusicProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MusicProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint1 = new Paint();
        mRectHeight = getMeasuredHeight();
        for (int i = 0; i < 10; i++) {
            mRandom = Math.random();
            mCurrentHeight = (float) (mRectHeight * mRandom);
            //给每个矩形添加渐变渲染器
            mLinearGradient = new LinearGradient(0, 0,
                    (float) (mRectWidth * (i + 1)),
                    mRectHeight, Color.RED, Color.YELLOW, Shader.TileMode.MIRROR);

            mPaint1.setShader(mLinearGradient);
            canvas.drawRect(
                    (float) (mRectWidth * i + offset),
                    mCurrentHeight,
                    (float) (mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint1
            );

        }
        postInvalidateDelayed(1000);
    }

}
