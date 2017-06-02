package com.coder.guoy.recyclerview.view.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/6/2
 * @Descrpiton:
 */
public class ShaderTextView extends AppCompatTextView {

    private Matrix mGradientMatrix;
    private LinearGradient mLinearGradient;//渐变渲染器
    private int mViewWidth;
    private int mTranslate;

    public ShaderTextView(Context context) {
        super(context);
    }

    public ShaderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(1000);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Paint mPaint = getPaint();
        mLinearGradient = new LinearGradient(0, 0, getMeasuredWidth(), 0,
                new int[]{Color.RED, Color.GREEN, Color.BLUE}, null, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
        mGradientMatrix = new Matrix();
    }

}
