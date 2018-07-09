package com.ly.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ly.demo.R;
import com.ly.liquid.Liquid;

/**
 * 普通Activity中使用
 */
public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        init();
    }

    private void init() {
        Liquid.showClickView(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
            }
        });
    }

    private void showLoading() {
        new Liquid.Builder()
                .setText("加载中")
                .build(this)
                .showLoadingView();

        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Liquid.clear(NormalActivity.this);
            }
        }, 1500);

    }
}
