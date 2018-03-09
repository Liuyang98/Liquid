package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangl.liu on 2018/3/5.
 * 总功能类，提供了默认静态类，也可以通过Builder创建实例
 */
public class Liquid {
    public static final int VIEW_ERROR = R.id.error_view;
    public static final int VIEW_LOADING = R.id.loading_view;
    public static final int VIEW_CUSTOM = R.id.custom_view;
    private static LiquidStyle liStyle = LiquidStyle.getDefault();
    private LiquidParams params;
    private static Liquid defaultInstance;

    public static Liquid getDefault() {
        if (defaultInstance == null) {
            synchronized (Liquid.class) {
                if (defaultInstance == null) {
                    defaultInstance = new Liquid(new LiquidParams());
                }
            }
        }
        return defaultInstance;
    }

    private Liquid(LiquidParams params) {
        this.params = params;
    }

    //TODO LOADING 模式需要修改

    /**
     * 显示网络加载布局——默认
     *
     * @param activity
     */
    public static void showLoadingView(Activity activity) {
        showLoadingView(getContentView(activity));
    }

    /**
     * 显示网络加载布局
     *
     * @param parentLayout——默认
     */
    public static void showLoadingView(ViewGroup parentLayout) {
        LiquidUtil.removeAllView(parentLayout);
        View layoutView = LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.layout_loading, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(VIEW_LOADING);
        parentLayout.addView(layoutView, mParams);

        LiquidUtil.setGifInfo(layoutView);
    }

    /**
     * 显示网络加载布局——params
     */
    public Liquid showLoadingView() {
        LiquidUtil.removeAllView(params.parentLayout);
        View layoutView = LayoutInflater.from(params.parentLayout.getContext()).inflate(R.layout.layout_loading, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(VIEW_LOADING);
        params.parentLayout.addView(layoutView, mParams);

        LiquidUtil.setGifInfo(layoutView);
        return this;
    }

    /**
     * 显示网络异常布局——默认
     */
    public static void showErrorView(Activity activity, View.OnClickListener clickListener) {
        showErrorView(getContentView(activity), clickListener);
    }

    /**
     * 显示网络异常布局——默认
     */
    public static void showErrorView(ViewGroup viewGroup, View.OnClickListener clickListener) {
        getDefault().doShowErrorView(viewGroup, liStyle.getNoneText(), liStyle.getNoneImage(), clickListener);
    }

    /**
     * 显示网络异常布局——param
     */
    public Liquid showErrorView() {
        String errContent = params.tipText == null ? liStyle.getErrorText() : params.tipText;
        int errImageRes = params.tipImageRes == 0 ? liStyle.getErrorIamge() : params.tipImageRes;
        doShowErrorView(params.parentLayout, errContent, errImageRes, params.listener);
        return this;
    }


    /**
     * 真正开始添加 自定义反馈布局的位置
     *
     * @param viewGroup     父容器
     * @param tipContent    提示文字
     * @param imageRes      提示图片
     * @param clickListener 点击事件
     */
    private void doShowErrorView(ViewGroup viewGroup, String tipContent, int imageRes, View.OnClickListener clickListener) {
        LiquidUtil.removeAllView(viewGroup);
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(VIEW_ERROR);
        viewGroup.addView(layoutView, mParams);
        layoutView.setOnClickListener(clickListener);
        LiquidUtil.setInfo(layoutView, tipContent, imageRes);
    }

    /**
     * 显示事务布局——默认
     *
     * @param activity
     */
    public static void showCustomView(Activity activity) {
        showCustomView(getContentView(activity));
    }

    /**
     * 显示事务布局——默认
     *
     * @param viewGroup
     */
    public static void showCustomView(ViewGroup viewGroup) {
        getDefault().doShowCustomView(viewGroup, liStyle.getNoneText(), liStyle.getNoneImage(), defaultListener);
    }

    /**
     * 显示事务布局——param
     */
    public void showCustomView() {
        String customTip = params.tipText == null ? liStyle.getNoneText() : params.tipText;
        int customImageRes = params.tipImageRes == 0 ? liStyle.getNoneImage() : params.tipImageRes;
        doShowCustomView(params.parentLayout, customTip, customImageRes, params.listener);
    }

    /**
     * 真正开始添加 自定义反馈布局的位置
     *
     * @param viewGroup     父容器
     * @param tipContent    提示文案
     * @param imageRes      提示图片
     * @param clickListener 点击事件
     */
    private void doShowCustomView(ViewGroup viewGroup, String tipContent, int imageRes, View.OnClickListener clickListener) {
        if (viewGroup == null) {
            Log.e("Liquid", "not found viewGroup");
            return;
        }
        LiquidUtil.removeAllView(viewGroup);
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(Liquid.VIEW_CUSTOM);

        viewGroup.addView(layoutView, mParams);
        layoutView.setOnClickListener(clickListener);
        LiquidUtil.setInfo(layoutView, tipContent, imageRes);
    }

    /**
     * 移除网络异常布布局——Actvitiy
     */
    public static void removeErrorView(Activity activity) {
        removeErrorView(getContentView(activity));
    }

    /**
     * 移除网络异常布局——ViewGroup
     */
    public static void removeErrorView(ViewGroup viewGroup) {
        Liquid.removeView(viewGroup, VIEW_ERROR);
    }

    /**
     * 移除网络加载中布局——Actvitiy
     */
    public static void removeLoadingView(Activity activity) {
        removeLoadingView(getContentView(activity));
    }

    /**
     * 移除网络加载中布局——ViewGroup
     */
    public static void removeLoadingView(ViewGroup viewGroup) {
        Liquid.removeView(viewGroup, VIEW_LOADING);
    }

    /**
     * 移除事务布局——Activity
     */
    public static void removeCustomView(Activity activity) {
        removeCustomView(getContentView(activity));
    }

    /**
     * 移除事务布局——ViewGroup
     */
    public static void removeCustomView(ViewGroup viewGroup) {
        Liquid.removeView(viewGroup, VIEW_CUSTOM);
    }

    /**
     * 建造者类
     */
    public static class Builder {
        private LiquidParams params;

        public Builder() {
            params = new LiquidParams();
        }

        public Builder setText(String tipText) {
            params.tipText = tipText;
            return this;
        }

        public Builder setImageRes(int tipImageRes) {
            params.tipImageRes = tipImageRes;
            return this;
        }

        public Builder setClickListener(View.OnClickListener listener) {
            params.listener = listener;
            return this;
        }

        public Liquid build(Activity activity) {
            return build(LiquidUtil.getContentView(activity));
        }

        public Liquid build(ViewGroup parentLayout) {
            params.parentLayout = parentLayout;
            return new Liquid(params);
        }
    }

    /**
     * 默认的监听，用来消化点击事件
     */
    private static View.OnClickListener defaultListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    /**
     * 通过View的ID将其从父容器中移除
     *
     * @param viewGroup
     * @param vid
     */
    private static void removeView(ViewGroup viewGroup, int vid) {
        viewGroup.removeView(viewGroup.findViewById(vid));
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
