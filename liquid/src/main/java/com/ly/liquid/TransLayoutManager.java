package com.ly.liquid;

/**
 * Created by yangl.liu on 2018/3/6.
 */

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

public class TransLayoutManager {
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
    public static void showErrorView(final Activity activity, View.OnClickListener clickListener) {
        showErrorView(activity, getContentView(activity), clickListener);
    }

    /**
     * 显示网络异常布局
     *
     * @param activity
     * @param parentLayout  父容器
     * @param clickListener 点击事件
     */
    public static void showErrorView(Activity activity, ViewGroup parentLayout, View.OnClickListener clickListener) {
        View layoutView = LayoutInflater.from(activity).inflate(R.layout.layout_error, null);
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
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        contentView.removeView(contentView.findViewById(ID_ERROR));
    }


    /**
     * 显示网络加载布局
     *
     * @param activity
     */
    public static void showLoadingView(Activity activity) {
        showLoadingView(activity, getContentView(activity));
    }

    public static void showLoadingView(Activity activity, ViewGroup parentLayout) {
        View layoutView = LayoutInflater.from(activity).inflate(R.layout.layout_loading, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_LOADING);
        parentLayout.addView(layoutView, mParams);

        GifImageView gifImageView = layoutView.findViewById(R.id.iv_gif);
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.start();
        setText(layoutView, resBean.getLoadText());
    }



    /**
     * 移除网络加载中布局
     */
    public static void removeNoneView(Activity activity) {
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        contentView.removeView(contentView.findViewById(ID_LOADING));
    }

    /**
     * 移除网络加载中布局
     */
    public static void removeLoadingView(Activity activity) {
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        contentView.removeView(contentView.findViewById(ID_NONE));
    }

    public static void showNoneView(Activity activity) {
        showNoneView(activity,getContentView(activity),resBean.getNoneText());
    }

    public static void showNoneView(Activity activity,String noneText) {
        showNoneView(activity,getContentView(activity),noneText);
    }

    public static void showNoneView(Activity activity, ViewGroup parentLayout) {
        showNoneView(activity,parentLayout,resBean.getNoneText());
    }

    public static void showNoneView(Activity activity, ViewGroup parentLayout,String noneText) {
        View layoutView = LayoutInflater.from(activity).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(ID_NONE);
        parentLayout.addView(layoutView, mParams);

        setInfo(layoutView, noneText, resBean.getNoneImage());
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
        TextView textView = layoutView.findViewById(R.id.tv_trans);
        image.setImageResource(imageRes);
        textView.setText(str);
        textView.setTextSize(resBean.getTextSize());
        textView.setTextSize(resBean.getTextSize());
        textView.setTextColor(resBean.getTextColor());
    }

    private static void setText(View layoutView, String str) {
        TextView textView = layoutView.findViewById(R.id.tv_trans);
        textView.setText(str);
        textView.setTextSize(resBean.getTextSize());
        textView.setTextSize(resBean.getTextSize());
        textView.setTextColor(resBean.getTextColor());
    }


    private static ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }

}
