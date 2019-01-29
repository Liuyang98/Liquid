package com.ly.liquid.pojo;

import com.ly.liquid.interfaces.LiquidLoader;

/**
 * Created by yangl.liu on 2018/3/6.
 * 全局风格控制类
 */
public class LiquidStyle {
    private volatile static LiquidStyle liquidStyle;
    private LiquidLoader liquidLoader;
    private int textSize;
    private int textColor;
    private Integer backgroundColor;
    private Integer clickLayoutRes;

    public static LiquidStyle getDefault() {
        if (liquidStyle == null) {
            synchronized (LiquidStyle.class) {
                if (liquidStyle == null) {
                    liquidStyle = new LiquidStyle();
                }
            }
        }
        return liquidStyle;
    }

    public static LiquidStyle init() {
        return getDefault();
    }

    public LiquidStyle setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public LiquidStyle setLiquidLoader(LiquidLoader liquidLoader) {
        this.liquidLoader = liquidLoader;
        return this;
    }

    public LiquidStyle setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public LiquidStyle setLayoutRes(Integer clickLayoutRes) {
        this.clickLayoutRes = clickLayoutRes;
        return this;
    }

    public LiquidStyle setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public LiquidLoader getLiquidLoader() {
        return liquidLoader;
    }

    public int getTextSize() {
        return textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public Integer getClickLayoutRes() {
        return clickLayoutRes;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }
}