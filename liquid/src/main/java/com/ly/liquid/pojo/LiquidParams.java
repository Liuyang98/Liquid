package com.ly.liquid.pojo;

import android.view.View;
import android.view.ViewGroup;

import com.ly.liquid.InterceptListener;

/**
 * Created by yangl.liu on 2018/3/9.
 * 自定义属性类（建造者模式使用）
 */
public class LiquidParams {
    //父布局
    public ViewGroup parentLayout;
    //提示文字
    public String tipText;
    //提示文字颜色
    public Integer tipTextColor;
    //提示文字大小
    public Integer tipTextSize;
    //提示图片
    public Integer tipImageRes;
    //拦截点击监听
    public InterceptListener interceptListener;
    //点击事件监听
    public View.OnClickListener clickListener;
    //背景色
    public Integer backgroundColor;

    public LiquidParams() {
        interceptListener = InterceptListener.getInstance();
    }
}
