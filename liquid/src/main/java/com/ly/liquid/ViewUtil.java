package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by yangl.liu on 2018/3/8.
 * 工具类，用于填充信息和提供静态方法
 */
public class ViewUtil {
    private static final String TAG = "ViewUtil";

    /**
     * 填充事务面板
     *
     * @param layoutView    父容器
     * @param tipText       提示文字
     * @param imageRes      提示图片
     * @param clickListener 点击事件
     */
    public static void setInfo(View layoutView, String tipText, int imageRes, int paramColor, View.OnClickListener clickListener) {
        //如果是gif布局，则处理完后退出
        if (isGifLayout(layoutView)) {
            ViewUtil.setGifInfo(layoutView, imageRes, tipText);
        } else {
            setTipInfo(layoutView, imageRes, tipText, clickListener);
        }
        setBackgroundColor(layoutView, paramColor);
    }

    /**
     * 填充tip面板
     *
     * @param layoutView    父容器
     * @param imageRes      图片资源
     * @param tipText       提示文字
     * @param clickListener 点击事件
     */
    private static void setTipInfo(View layoutView, int imageRes, String tipText, View.OnClickListener clickListener) {
        ImageView image = layoutView.findViewById(R.id.iv_tip);
        if (image == null) {
            Log.e(TAG, "not found ImageView R.id.tip");
            return;
        }
        image.setImageResource(imageRes);
        setText(layoutView, tipText);
        layoutView.setOnClickListener(clickListener);
    }

    /**
     * 填充GIF面板
     *
     * @param layoutView 父容器
     * @param rid        GIF资源
     * @param tipText    提示文字
     */
    private static void setGifInfo(View layoutView, int rid, String tipText) {
        String tip = tipText.isEmpty() ? LiquidStyle.getDefault().getLoadText() : tipText;
        setText(layoutView, tip);
        startGifAnim(layoutView, rid);
    }

    /**
     * 设置提示文案
     *
     * @param layoutView 父布局
     * @param str        提示文案
     */
    private static void setText(View layoutView, String str) {
        LiquidStyle style = LiquidStyle.getDefault();
        TextView textView = layoutView.findViewById(R.id.tv_tip);
        if (textView == null) {
            Log.e(TAG, "not found TextView R.id.tv_tip");
            return;
        }
        textView.setText(str);
        textView.setTextSize(style.getTextSize());
        textView.setTextColor(style.getTextColor());
    }

    /**
     * 设置背景
     *
     * @param layoutView
     * @param paramColor
     */
    private static void setBackgroundColor(View layoutView, int paramColor) {
        LiquidStyle liStyle = LiquidStyle.getDefault();
        if (paramColor == 0) {
            if (liStyle.getBackgroundColor() != 0) {
                layoutView.setBackgroundColor(liStyle.getBackgroundColor());
            }
        } else {
            layoutView.setBackgroundColor(paramColor);
        }
    }

    private static void startGifAnim(View layoutView, int rid) {
        //播放gif动画
        GifImageView gifImageView = layoutView.findViewById(R.id.iv_gif);
        if (gifImageView == null) {
            Log.e(TAG, "not found GifImageView R.id.iv_gif");
            return;
        }
        gifImageView.setImageResource(rid);
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        if (gifDrawable == null) {
            Log.e(TAG, "gifDrawable == null");
        } else {
            gifDrawable.start();
        }
    }

    /**
     * 获取 Content控件
     *
     * @param activity
     * @return
     */
    public static ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }

    /**
     * 判断是否Gif布局
     */
    private static boolean isGifLayout(View viewGroup) {
        return viewGroup.findViewById(R.id.iv_gif) != null;
    }
}
