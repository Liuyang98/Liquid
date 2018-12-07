package com.ly.liquid;

import com.ly.liquid.interfaces.LiquidLoader;

/**
 * Created by yangl.liu on 2018/3/6.
 * 全局风格控制类
 */
public class LiquidStyle {
    private volatile static LiquidStyle liquidStyle;
    private LiquidLoader liquidLoader;
    private String errorText;
    private String loadText;
    private String noneText;
    private int errorIamge;
    private int loadImage;
    private int noneImage;
    private int textSize;
    private int textColor;
    private Integer backgroundColor;
    private Integer gifLayoutRes;
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

    public LiquidStyle setErrorIamge(int errorIamge) {
        this.errorIamge = errorIamge;
        return this;
    }

    public LiquidStyle setLoadImage(int loadImage) {
        this.loadImage = loadImage;
        return this;
    }

    public LiquidStyle setNoneImage(int noneImage) {
        this.noneImage = noneImage;
        return this;
    }

    public LiquidStyle setErrorText(String errorText) {
        this.errorText = errorText;
        return this;
    }

    public LiquidStyle setLoadText(String loadText) {
        this.loadText = loadText;
        return this;
    }

    public LiquidStyle setNoneText(String noneText) {
        this.noneText = noneText;
        return this;
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

    public LiquidStyle setGifLayoutRes(Integer gifLayoutRes) {
        this.gifLayoutRes = gifLayoutRes;
        return this;
    }

    public LiquidStyle setClickLayoutRes(Integer clickLayoutRes) {
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

    public int getErrorIamge() {
        return errorIamge;
    }

    public int getLoadImage() {
        return loadImage;
    }

    public int getNoneImage() {
        return noneImage;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getLoadText() {
        return loadText;
    }

    public String getNoneText() {
        return noneText;
    }

    public int getTextSize() {
        return textSize;
    }

    public int getTextColor() {
        return textColor;
    }


    public Integer getGifLayoutRes() {
        return gifLayoutRes;
    }

    public Integer getClickLayoutRes() {
        return clickLayoutRes;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }
}