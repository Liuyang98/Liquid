package com.ly.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.ly.demo.R;
import com.ly.liquid.Liquid;

/**
 * 指定父容器类型
 */
public class ViewGroupActivity extends AppCompatActivity {
    private LinearLayout mLlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewgroup);

        init();
    }

    private void init() {
        mLlayout = findViewById(R.id.llayout);
        Liquid.showClickView(mLlayout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
            }
        });
    }

    private void showLoading() {
        Liquid.showLoadingView(mLlayout);
        mLlayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                Liquid.clear(mLlayout);
            }
        }, 1500);
    }
}
