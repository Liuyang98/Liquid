package com.ly.demo.application;

import android.app.Application;

import com.ly.demo.R;
import com.ly.liquid.TransLayoutManager;
import com.ly.liquid.TransResBean;

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
            TransResBean transResBean = TransResBean.getInstance();
            //也可以改成构造方法方式
            transResBean
                    .setErrorIamge(R.mipmap.trans_fail)
                    .setLoadImage(R.mipmap.trans_loading)
                    .setNoneImage(R.mipmap.trans_none)
                    .setErrorText("网络加载异常")
                    .setLoadText("加载中")
                    .setNoneText("没有找到内容")
                    .setTextColor(0xffdddddd)
                    .setTextSize(20);

            TransLayoutManager.init(transResBean);
    }
}
