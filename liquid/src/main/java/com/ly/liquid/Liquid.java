package com.ly.liquid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by yangl.liu on 2018/3/5.
 */
public class Liquid {
    private static final int ID_ERROR = R.id.error_view;
    private static final int ID_LOADING = R.id.loading_view;
    private static final int ID_NONE = R.id.none_view;
    private static TransResBean resBean;

    public static void init(TransResBean transResBean) {
        resBean = transResBean;
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
        removeAllView(parentLayout);
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_ERROR);
        parentLayout.addView(layoutView, mParams);
        layoutView.setOnClickListener(clickListener);
        setInfo(layoutView, resBean.getErrorText(), resBean.getErrorIamge());
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
        removeAllView(parentLayout);
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_loading, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_LOADING);
        parentLayout.addView(layoutView, mParams);
        //播放gif动画
        GifImageView gifImageView = layoutView.findViewById(R.id.iv_gif);
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.start();
        setText(layoutView, resBean.getLoadText());
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
     * 显示其他信息提示布局
     *
     * @param activity
     */
    public static void showNoneView(Activity activity) {
        showNoneView(getContentView(activity), resBean.getNoneText());
    }

    /**
     * 显示其他信息提示布局
     *
     * @param parentLayout
     */
    public static void showNoneView(ViewGroup parentLayout) {
        showNoneView(parentLayout, resBean.getNoneText());
    }

    /**
     * 显示其他信息提示布局
     *
     * @param activity
     * @param noneText
     */
    public static void showNoneView(Activity activity, String noneText) {
        showNoneView(getContentView(activity), noneText);
    }

    /**
     * 显示其他信息提示布局
     *
     * @param parentLayout 父布局
     * @param noneText     提示文案
     */
    public static void showNoneView(ViewGroup parentLayout, String noneText) {
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_NONE);
        parentLayout.addView(layoutView, mParams);

        setInfo(layoutView, noneText, resBean.getNoneImage());
    }

    /**
     * 移除其他信息提示布局
     */
    public static void removeNoneView(Activity activity) {
        removeNoneView(getContentView(activity));
    }

    /**
     * 移除其他信息提示布局
     */
    public static void removeNoneView(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(ID_NONE));
    }

    /**
     * 填充事务面板
     *
     * @param layoutView
     * @param str
     * @param imageRes
     */
    private static void setInfo(View layoutView, String str, int imageRes) {
        ImageView image = layoutView.findViewById(R.id.iv_trans);
        image.setImageResource(imageRes);
        setText(layoutView, str);
    }

    /**
     * 设置提示文案
     *
     * @param layoutView 父布局
     * @param str        提示文案
     */
    private static void setText(View layoutView, String str) {
        TextView textView = layoutView.findViewById(R.id.tv_trans);
        textView.setText(str);
        textView.setTextSize(resBean.getTextSize());
        textView.setTextSize(resBean.getTextSize());
        textView.setTextColor(resBean.getTextColor());
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

    /**
     * 删除框架添加的布局控件
     *
     * @param viewGroup
     */
    public static void removeAllView(ViewGroup viewGroup) {
        removeLoadingView(viewGroup);
        removeErrorView(viewGroup);
        removeNoneView(viewGroup);
    }

}
