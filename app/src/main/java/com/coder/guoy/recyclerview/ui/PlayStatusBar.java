package com.coder.guoy.recyclerview.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import com.coder.guoy.recyclerview.R;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:2017年4月21日
 * @Descrpiton:StatusBar|透明状态栏
 */
public class PlayStatusBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_status_bar);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setLayoutAnimation();
    }


    private void setLayoutAnimation() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_play_status_bar);
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(300);
        LayoutAnimationController controller = new LayoutAnimationController(alpha, 0.3f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layout.setLayoutAnimation(controller);
    }
}
