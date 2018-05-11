package com.ly.liquid;

import android.view.View;

/**
 * Created by yangl.liu on 2018/5/11.
 * 拦截点击事件的监听器
 */
public class InterceptListener implements View.OnClickListener {
    private static InterceptListener interceptListener;

    private InterceptListener() {
    }

    public static InterceptListener getInstance() {
        if (interceptListener == null) {
            synchronized (Liquid.class) {
                if (interceptListener == null) {
                    interceptListener = new InterceptListener();
                }
            }
        }
        return interceptListener;
    }

    @Override
    public void onClick(View v) {

    }
}
