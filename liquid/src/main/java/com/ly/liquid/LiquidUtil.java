package com.ly.liquid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by yangl.liu on 2018/3/8.
 */

public class LiquidUtil {

    /**
     * 删除框架添加的布局控件
     *
     * @param viewGroup
     */
    public static void removeAllView(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(Liquid.VIEW_CUSTOM));
        viewGroup.removeView(viewGroup.findViewById(Liquid.VIEW_ERROR));
        viewGroup.removeView(viewGroup.findViewById(Liquid.VIEW_LOADING));
    }

    /**
     * 填充事务面板
     *
     * @param layoutView
     * @param str
     * @param imageRes
     */
    public static void setInfo(View layoutView, String str, int imageRes) {
        setText(layoutView, str);
        ImageView image = layoutView.findViewById(R.id.iv_trans);
        image.setImageResource(imageRes);
    }

    /**
     * 填充Loading事务面板
     *
     * @param layoutView
     */
    public static void setGifInfo(View layoutView) {
        setText(layoutView, LiquidStyle.getDefault().getLoadText());
        //播放gif动画
        GifImageView gifImageView = layoutView.findViewById(R.id.iv_gif);
        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.start();
    }

    /**
     * 设置提示文案
     *
     * @param layoutView 父布局
     * @param str        提示文案
     */
    public static void setText(View layoutView, String str) {
        LiquidStyle style = LiquidStyle.getDefault();
        TextView textView = layoutView.findViewById(R.id.tv_trans);
        textView.setText(str);
        textView.setTextSize(style.getTextSize());
        textView.setTextColor(style.getTextColor());
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
}
