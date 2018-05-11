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
public class LiquidUtil {
    /**
     * 填充事务面板
     *
     * @param layoutView 父容器
     * @param str 提示文字
     * @param imageRes 提示图片
     */
    public static void setInfo(View layoutView, String str, int imageRes, int paramColor) {
        setBackgroundColor(layoutView, paramColor);
        //判断类型
        if (isGifLayout(layoutView)) {
            LiquidUtil.setGifInfo(layoutView, imageRes);
            return;
        }

        ImageView image = layoutView.findViewById(R.id.iv_tip);
        if (image == null) {
            Log.e("LiquidUtil", "not found image");
            return;
        }
        image.setImageResource(imageRes);
        setText(layoutView, str);
    }

    /**
     * 填充GIF面板
     *
     * @param layoutView 父容器
     * @param rid        GIF资源
     */
    public static void setGifInfo(View layoutView, int rid) {
        //播放gif动画
        GifImageView gifImageView = layoutView.findViewById(R.id.iv_gif);
        if (gifImageView == null) {
            Log.e("LiquidUtil", "not found gifView");
            return;
        }
        gifImageView.setImageResource(rid);
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        if (gifDrawable == null) {
            Log.e("LiquidUtil", "not found gifDrawable");
            return;
        }
        gifDrawable.start();
        setText(layoutView, LiquidStyle.getDefault().getLoadText());
    }

    /**
     * 设置提示文案
     *
     * @param layoutView 父布局
     * @param str        提示文案
     */
    public static void setText(View layoutView, String str) {
        LiquidStyle style = LiquidStyle.getDefault();
        TextView textView = layoutView.findViewById(R.id.tv_tip);
        if (textView == null) {
            Log.e("LiquidUtil", "not found textView");
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
    public static void setBackgroundColor(View layoutView, int paramColor) {
        LiquidStyle liStyle = LiquidStyle.getDefault();
        if (paramColor == 0) {
            if (liStyle.getBackgroundColor() != 0) {
                layoutView.setBackgroundColor(liStyle.getBackgroundColor());
            }
        } else {
            layoutView.setBackgroundColor(paramColor);
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
