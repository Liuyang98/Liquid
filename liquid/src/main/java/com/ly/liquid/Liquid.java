package com.ly.liquid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangl.liu on 2018/3/5.
 */
public class Liquid {
    public static final int ID_ERROR = R.id.error_view;
    public static final int ID_LOADING = R.id.loading_view;
    public static final int ID_CUSTOM = R.id.custom_view;
    private static LiquidStyle liStyle;

    public static void init(LiquidStyle liquidStyle) {
        liStyle = liquidStyle;
    }

    /**
     * 显示网络异常布局
     *
     * @param activity
     */
    public static void showErrorView(Activity activity, View.OnClickListener clickListener) {
        showErrorView(getContentView(activity), clickListener);
    }

    /**
     * 显示网络异常布局
     *
     * @param parentLayout  父容器
     * @param clickListener 点击事件
     */
    public static void showErrorView(ViewGroup parentLayout, View.OnClickListener clickListener) {
        LiquidUtil.removeAllView(parentLayout);
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_ERROR);
        parentLayout.addView(layoutView, mParams);
        layoutView.setOnClickListener(clickListener);
        LiquidUtil.setInfo(layoutView, liStyle.getErrorText(), liStyle.getErrorIamge());
    }

    /**
     * 移除网络异常布局
     */
    public static void removeErrorView(Activity activity) {
        removeErrorView(getContentView(activity));
    }

    /**
     * 移除网络异常布局
     */
    public static void removeErrorView(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(ID_ERROR));
    }

    /**
     * 显示网络加载布局
     *
     * @param activity
     */
    public static void showLoadingView(Activity activity) {
        showLoadingView(getContentView(activity));
    }

    /**
     * 显示网络加载布局
     *
     * @param parentLayout
     */
    public static void showLoadingView(ViewGroup parentLayout) {
        LiquidUtil.removeAllView(parentLayout);
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_loading, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_LOADING);
        parentLayout.addView(layoutView, mParams);

        LiquidUtil.setGifInfo(layoutView);
    }

    /**
     * 移除网络加载中布局
     */
    public static void removeLoadingView(Activity activity) {
        removeLoadingView(getContentView(activity));
    }

    /**
     * 移除网络加载中布局
     */
    public static void removeLoadingView(ViewGroup view) {
        view.removeView(view.findViewById(ID_LOADING));
    }

    /**
     * 获取 Content控件
     *
     * @param activity
     * @return
     */
    private static ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }
}
