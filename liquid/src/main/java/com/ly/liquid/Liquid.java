package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by yangl.liu on 2018/3/5.
 * 总功能类，提供了默认静态类，也可以通过Builder创建实例
 * <p>
 * tipView   ：提供文案，提供静态图，无点击事件
 * clickView ：提供文案，提供静态图，有点击事件
 * gifView   ：提供文案，提供GIF图，无点击事件
 */
public class Liquid {
    private static final int VIEW_LIQUID = R.id.liquid_view;
    private volatile static Liquid defaultInstance;
    private static final LiquidStyle liStyle = LiquidStyle.getDefault();
    private LiquidParams params;

    private static Liquid getDefault() {
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

    /**
     * 显示简单提示布局（无点击事件）——默认
     */
    public static void showTipView(Activity activity) {
        showTipView(ViewUtil.getContentView(activity));
    }

    /**
     * 显示简单提示布局（无点击事件）——默认
     */
    public static void showTipView(ViewGroup viewGroup) {
        getDefault().doClickLayout(viewGroup, liStyle.getNoneText(), liStyle.getNoneImage(), getDefault().params.interceptListener);
    }

    /**
     * 显示简单提示布局（无点击事件）——param
     */
    public void showTipView() {
        String customTip = params.tipText == null ? liStyle.getNoneText() : params.tipText;
        int customImageRes = params.tipImageRes == 0 ? liStyle.getNoneImage() : params.tipImageRes;
        doClickLayout(params.parentLayout, customTip, customImageRes, params.interceptListener);
    }

    /**
     * 显示点击事件布局——默认
     */
    public static void showClickView(Activity activity, View.OnClickListener clickListener) {
        showClickView(ViewUtil.getContentView(activity), clickListener);
    }

    /**
     * 显示点击事件布局——默认
     */
    public static void showClickView(ViewGroup viewGroup, View.OnClickListener clickListener) {
        getDefault().doClickLayout(viewGroup, liStyle.getNoneText(), liStyle.getNoneImage(), clickListener);
    }

    /**
     * 显示点击事件布局——param
     */
    public void showClickView() {
        String errContent = params.tipText == null ? liStyle.getErrorText() : params.tipText;
        int errImageRes = params.tipImageRes == 0 ? liStyle.getErrorIamge() : params.tipImageRes;
        doClickLayout(params.parentLayout, errContent, errImageRes, params.clickListener);
    }

    /**
     * 显示网络加载布局——默认
     */
    public static void showLoadingView(Activity activity) {
        showLoadingView(ViewUtil.getContentView(activity));
    }

    /**
     * 显示网络加载布局——默认
     */
    public static void showLoadingView(ViewGroup parentLayout) {
        getDefault().doGifLayout(parentLayout, "", liStyle.getLoadImage());
    }

    /**
     * 显示网络加载布局——params
     */
    public void showLoadingView() {
        int customImageRes = params.tipImageRes == 0 ? liStyle.getLoadImage() : params.tipImageRes;
        doGifLayout(params.parentLayout, params.tipText, customImageRes);
    }

    /**
     * 显示网络加载布局
     *
     * @param viewGroup 父容器
     * @param imageRes  GIF资源
     */
    private void doGifLayout(ViewGroup viewGroup, String tipText, int imageRes) {
        int loadingRid = liStyle.getGifLayoutRes() == 0 ? R.layout.liquid_default_layout_loading : liStyle.getGifLayoutRes();
        beginShowLayout(viewGroup, tipText, imageRes, loadingRid, getDefault().params.interceptListener);
    }

    /**
     * 显示点击事件布局（非GIF）
     *
     * @param viewGroup     父容器
     * @param tipText       提示文案
     * @param imageRes      提示图片
     * @param clickListener 点击监听
     */
    private void doClickLayout(ViewGroup viewGroup, String tipText, int imageRes, View.OnClickListener clickListener) {
        int clickRid = liStyle.getClickLayoutRes() == 0 ? R.layout.liquid_default_layout_error : liStyle.getClickLayoutRes();
        beginShowLayout(viewGroup, tipText, imageRes, clickRid, clickListener);
    }

    /**
     * 添加布局
     *
     * @param viewGroup     父容器
     * @param tipText       提示文案
     * @param imageRes      提示图片
     * @param LayoutRes     父布局资源
     * @param clickListener 点击监听
     */
    private void beginShowLayout(ViewGroup viewGroup, String tipText, int imageRes, int LayoutRes, View.OnClickListener clickListener) {
        if (viewGroup == null) {
            Log.e("Liquid", "not found viewGroup");
            return;
        }
        Liquid.clear(viewGroup);
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(LayoutRes, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        childView.setId(VIEW_LIQUID);
        int vIndex = viewGroup instanceof LinearLayout ? 0 : -1;
        viewGroup.addView(childView, vIndex, mParams);
        ViewUtil.setInfo(childView, tipText, imageRes, params.backgroundColor, clickListener);
    }

    /**
     * 移除网络异常布布局——Actvitiy
     */
    public static void clear(Activity activity) {
        clear(ViewUtil.getContentView(activity));
    }

    /**
     * 移除网络异常布局——ViewGroup
     */
    public static void clear(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(VIEW_LIQUID));
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

        public Builder setBackgroundColor(int backgroundColor) {
            params.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setClickListener(View.OnClickListener listener) {
            params.clickListener = listener;
            return this;
        }

        public Liquid build(Activity activity) {
            return build(ViewUtil.getContentView(activity));
        }

        public Liquid build(ViewGroup parentLayout) {
            params.parentLayout = parentLayout;
            return new Liquid(params);
        }
    }
}
