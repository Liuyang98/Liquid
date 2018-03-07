package com.ly.liquid;

/**
 * Created by yangl.liu on 2018/3/6.
 */


public class TransResBean {
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

    private static TransResBean transResBean;

    public static TransResBean getInstance() {
        if (transResBean == null) {
            transResBean = new TransResBean();
        }
        return transResBean;
    }

    private TransResBean() {
    }

    public TransResBean setErrorIamge(int errorIamge) {
        this.errorIamge = errorIamge;
        return this;
    }

    public TransResBean setLoadImage(int loadImage) {
        this.loadImage = loadImage;
        return this;
    }

    public TransResBean setNoneImage(int noneImage) {
        this.noneImage = noneImage;
        return this;
    }

    public TransResBean setErrorText(String errorText) {
        this.errorText = errorText;
        return this;
    }

    public TransResBean setLoadText(String loadText) {
        this.loadText = loadText;
        return this;
    }

    public TransResBean setNoneText(String noneText) {
        this.noneText = noneText;
        return this;
    }

    public TransResBean setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public TransResBean setTextColor(int textColor) {
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