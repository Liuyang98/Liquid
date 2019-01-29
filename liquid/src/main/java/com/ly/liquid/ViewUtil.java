package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ly.liquid.pojo.LiquidParams;
import com.ly.liquid.pojo.LiquidStyle;

/**
 * Created by yangl.liu on 2018/3/8.
 * 工具类，用于填充信息和提供静态方法
 */
public class ViewUtil {
    private static final String TAG = "Liquid";

    public static void setInfo(View layoutView, LiquidParams liquidParams) {
        setTipInfo(layoutView, liquidParams);
        if (liquidParams.backgroundColor != null) {
            layoutView.setBackgroundColor(liquidParams.backgroundColor);
        } else if (LiquidStyle.getDefault().getBackgroundColor() != null) {
            layoutView.setBackgroundColor(LiquidStyle.getDefault().getBackgroundColor());
        }
    }

    /**
     * 填充tip面板
     *
     * @param layoutView 父布局
     */
    private static void setTipInfo(View layoutView, LiquidParams params) {
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
        Log.e(TAG, "params.asGif: "+params.asGif +"  :   (style.getLiquidLoader() != null)"+(style.getLiquidLoader() != null) );

        if (params.asGif) {
            if (style.getLiquidLoader() != null) {
                style.getLiquidLoader().loadGif(image, params.imgRes);
            }
        } else {
            if (style.getLiquidLoader() == null) {
                image.setImageResource(params.imgRes);
            } else {
                style.getLiquidLoader().load(image, params.imgRes);
            }
        }
        textView.setText(params.text);
        textView.setTextSize(params.textSize == null ? style.getTextSize() : params.textSize);
        textView.setTextColor(params.textColor == null ? style.getTextColor() : params.textColor);
        layoutView.setOnClickListener(params.clickListener);
    }

    /**
     * 获取 Content控件
     */
    public static ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }
}
