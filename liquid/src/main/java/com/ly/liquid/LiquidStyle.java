package com.ly.liquid;

/**
 * Created by yangl.liu on 2018/3/6.
 * 资源风格控制 ---名称需修改
 */
public class LiquidStyle {
    private int errorIamge;
    private int loadImage;
    private int noneImage;

    private String errorText;
    private String loadText;
    private String noneText;

    private int textSize;
    private int textColor;
    //还需要无网络和网络异常的区分，背景色
    //模式，宽高

    private static LiquidStyle transResBean;

    public static LiquidStyle getDefault() {
        if (transResBean == null) {
            transResBean = new LiquidStyle();
        }
        return transResBean;
    }

    public static LiquidStyle init(){
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

    public LiquidStyle setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
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
}