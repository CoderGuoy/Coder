package com.coder.guoy.recyclerview.ui.tagcloud;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.coder.guoy.recyclerview.R;
import com.coder.guoy.recyclerview.view.tagcloud.TagCloudView;

public class TagCloudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_cloud);
        TagCloudView tagCloud = (TagCloudView) findViewById(R.id.tag_cloud);
        tagCloud.setBackgroundColor(Color.LTGRAY);
        TagCloudAdapter adapter = new TagCloudAdapter(new String[100]);
        tagCloud.setAdapter(adapter);
    }
}
