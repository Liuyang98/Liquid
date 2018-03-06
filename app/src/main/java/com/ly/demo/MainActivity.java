package com.ly.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ly.liquid.TransLayoutManager;
import com.ly.liquid.TransResBean;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTrans();
        showLoadView();
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
                .setTextSize(30);

        TransLayoutManager.init(transResBean);
    }

    private void showLoadView() {
        TransLayoutManager.showErrorView(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransLayoutManager.removeErrorView(MainActivity.this);
            }
        });

//        TransLayoutManager. showLoadingView(this);
//        TransLayoutManager.showNoneView(this);
    }


}
