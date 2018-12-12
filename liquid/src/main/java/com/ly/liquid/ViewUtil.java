package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ly.liquid.interfaces.Allem;
import com.ly.liquid.pojo.LiquidParams;
import com.ly.liquid.pojo.LiquidStyle;

/**
 * Created by yangl.liu on 2018/3/8.
 * 工具类，用于填充信息和提供静态方法
 */
public class ViewUtil {
    private static final String TAG = "Liquid";

    /**
     * 填充事务面板
     *
     * @param layoutView    父布局
     * @param tipText       提示文字
     * @param imageRes      提示图片
     * @param clickListener 点击事件
     */
    public static void setInfo(View layoutView, String tipText, int imageRes, LiquidParams liquidParams, int layoutType, View.OnClickListener clickListener) {
        setTipInfo(layoutView, tipText, imageRes, liquidParams, layoutType, clickListener);
        if (liquidParams.backgroundColor != null) {
            layoutView.setBackgroundColor(liquidParams.backgroundColor);
        } else if (LiquidStyle.getDefault().getBackgroundColor() != null) {
            layoutView.setBackgroundColor(LiquidStyle.getDefault().getBackgroundColor());
        }
    }

    /**
     * 填充tip面板
     *
     * @param layoutView    父布局
     * @param imageRes      图片资源
     * @param tipText       提示文字
     * @param clickListener 点击事件
     */
    private static void setTipInfo(View layoutView, String tipText, int imageRes, LiquidParams liquidParams, int layoutType, View.OnClickListener clickListener) {
        ImageView image = layoutView.findViewById(R.id.iv_tip);
        TextView textView = layoutView.findViewById(R.id.tv_tip);
        if (textView == null) {
            Log.e(TAG, "not found TextView R.id.tv_tip");
            return;
        }
        if (image == null) {
            Log.e(TAG, "not found ImageView R.id.tip");
            return;
        }

        LiquidStyle style = LiquidStyle.getDefault();
        if (layoutType == Allem.LAYOUT_TYPE.GIF) {
            if (style.getLiquidLoader() != null) {
                style.getLiquidLoader().load(image, imageRes);
            }
        } else {
            image.setImageResource(imageRes);
        }
        textView.setText(tipText);
        textView.setTextSize(liquidParams.tipTextSize == null ? style.getTextSize() : liquidParams.tipTextSize);
        textView.setTextColor(liquidParams.tipTextColor == null ? style.getTextColor() : liquidParams.tipTextColor);
        layoutView.setOnClickListener(clickListener);
    }

    /**
     * 获取 Content控件
     */
    public static ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }
}
