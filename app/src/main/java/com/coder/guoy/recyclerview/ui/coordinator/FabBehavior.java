package com.coder.guoy.recyclerview.ui.coordinator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Version:
 * @Author:
 * @CreateTime:
 * @Descrpiton:
 */
public class FabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private int directionChange;

    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //判断滑动的方向 返回垂直滑动
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    //根据滑动的距离显示和隐藏 child
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0) {
            directionChange = 0;
        }
        directionChange += dy;
        if (directionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
            child.setVisibility(View.GONE);
        } else if (directionChange < 0 && child.getVisibility() == View.GONE) {
            child.setVisibility(View.VISIBLE);
        }
    }
}
