package com.coder.guoy.recyclerview.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coder.guoy.recyclerview.R;

/**
 * @Version:v1.0
 * @Author:Guoy
 * @CreateTime:
 * @Descrpiton:ActivityTransitions|转场动画
 */
public class PlayActivityTransitions extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private LinearLayout layoutGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_transitions);
        TextView textView = (TextView) findViewById(R.id.textview_title);
        FrameLayout layout = (FrameLayout) findViewById(R.id.toolbar_back);
        layoutGo = (LinearLayout) findViewById(R.id.layout_go);
        imageView = (ImageView) findViewById(R.id.image_go);
        textView.setText("ActivityTransitions|转场动画");
        layout.setOnClickListener(this);
        layoutGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.layout_go:
                Intent intent = new Intent(PlayActivityTransitions.this, PlayStatusBar.class);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(
                        this, imageView, "shareimage").toBundle();
                startActivity(intent, options);
                break;
        }
    }
}
