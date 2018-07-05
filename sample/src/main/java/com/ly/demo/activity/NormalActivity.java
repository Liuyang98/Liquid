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
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        init();
    }

    private void init() {
        textView = findViewById(R.id.tv);
        Liquid.showClickView(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
            }
        });
    }

    private void showLoading() {
        //TODO 是否能把buid和show合并，内部仍为建造者模式，但外部不体现
        new Liquid.Builder().setText("加载中……").build(this).showLoadingView();

        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Liquid.clear(NormalActivity.this);
            }
        }, 1500);
    }
}
