package com.ly.demo.application;

import android.app.Application;

import com.ly.demo.R;
import com.ly.demo.interfaces.SampleLoader;
import com.ly.liquid.pojo.LiquidStyle;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initTrans();
    }

    private void initTrans() {
        LiquidStyle
                .init()
                .setLayoutRes(R.layout.layout_error)
                .setBackgroundColor(0xffffffff)
                .setLiquidLoader(new SampleLoader());
    }
}
