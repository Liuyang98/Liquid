package com.ly.demo.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.ly.demo.R;
import com.ly.liquid.Liquid;

public class SampleUtil {

    public static void showLoading(ViewGroup viewGroup) {
        new Liquid.Builder()
                .setText("加载中")
                .setTextSize(20)
                .setTextColor(0xffdddddd)
                .setImg(R.mipmap.trans_load)
                .asGif()
                .build(viewGroup)
                .show();

    }

    public static void showLoading(Activity activity) {
        new Liquid.Builder()
                .setText("加载中")
                .setTextSize(20)
                .setTextColor(0xffdddddd)
                .setImg(R.mipmap.trans_load)
                .asGif()
                .build(activity)
                .show();
    }


    public static void showErrorLayout(ViewGroup viewGroup, View.OnClickListener clickListener) {
        new Liquid.Builder()
                .setText("网络异常")
                .setTextSize(20)
                .setTextColor(0xffdddddd)
                .setImg(R.mipmap.trans_fail)
                .setClickListener(clickListener)
                .build(viewGroup)
                .show();

    }

    public static void showErrorLayout(Activity activity, View.OnClickListener clickListener) {
        new Liquid.Builder()
                .setText("网络异常")
                .setTextSize(20)
                .setTextColor(0xffdddddd)
                .setImg(R.mipmap.trans_fail)
                .setClickListener(clickListener)
                .build(activity)
                .show();
    }

    public static void showErrorLayout(Activity activity, int layoutId, View.OnClickListener clickListener) {
        new Liquid.Builder()
                .setText("网络异常")
                .setTextSize(20)
                .setTextColor(0xffdddddd)
                .setImg(R.mipmap.trans_fail)
                .setClickListener(clickListener)
                .setLayoutId(layoutId)
                .build(activity)
                .show();
    }
}
