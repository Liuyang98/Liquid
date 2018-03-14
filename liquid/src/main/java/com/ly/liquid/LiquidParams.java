package com.ly.liquid;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangl.liu on 2018/3/9.
 * 自定义属性类（建造者模式使用）
 */

public class LiquidParams {
    //父布局
    public ViewGroup parentLayout;
    //提示文字
    public String tipText;
    //提示图片
    public int tipImageRes;
    //点击监听
    public View.OnClickListener listener;
    //背景色
    public int backgroundColor;
}
