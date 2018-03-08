package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yangl.liu on 2018/3/8.
 */

public class CustomView {
    private Activity activity;
    private ViewGroup viewGroup;
    private String content;
    private int imageRes;
    private View.OnClickListener clickListener;


    public CustomView(CustomViewBuilder builder) {
        activity = builder.getActivity();
        clickListener = builder.getClickListener();

        String defaultContent = LiquidStyle.getDefault().getNoneText();
        int defaultImageRes = LiquidStyle.getDefault().getNoneImage();

        viewGroup = activity == null ? builder.getViewGroup() : getContentView(activity);
        content = builder.getContent() == null ? defaultContent : builder.getContent();
        imageRes = builder.getImageRes() == 0 ? defaultImageRes : builder.getImageRes();
    }

    public CustomView show() {
        if (viewGroup == null) {
            Log.e("CustomView", "not found viewGroup");
            return this;
        }

        LiquidUtil.removeAllView(viewGroup);
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_error, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setId(Liquid.ID_CUSTOM);
        viewGroup.addView(layoutView, mParams);
        LiquidUtil.setInfo(layoutView,content,imageRes);
        layoutView.setOnClickListener(clickListener);
        return this;
    }

    public void remove(Activity activity) {
        remove(getContentView(activity));
    }

    public void remove(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(Liquid.ID_CUSTOM));
    }

    private ViewGroup getContentView(Activity activity) {
        return activity.findViewById(android.R.id.content);
    }
}
