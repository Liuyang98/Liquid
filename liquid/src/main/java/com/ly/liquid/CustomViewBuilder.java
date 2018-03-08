package com.ly.liquid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangl.liu on 2018/3/8.
 */

public class CustomViewBuilder {
    private Activity activity;
    private ViewGroup viewGroup;
    private String content;
    private int imageRes;
    private View.OnClickListener clickListener;


    public Activity getActivity() {
        return activity;
    }

    public CustomViewBuilder setActivity(Activity activity) {
        this.activity = activity;
        return  this;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public CustomViewBuilder setViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        return  this;
    }

    public String getContent() {
        return content;
    }

    public CustomViewBuilder setContent(String content) {
        this.content = content;
        return  this;
    }

    public int getImageRes() {
        return imageRes;
    }

    public CustomViewBuilder setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return  this;
    }

    public CustomViewBuilder setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        return  this;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public CustomView  build(){
        return new CustomView(this);
    }
}
