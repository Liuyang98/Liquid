package com.ly.liquid;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ly.liquid.pojo.LiquidParams;
import com.ly.liquid.pojo.LiquidStyle;

/**
 * Created by yangl.liu on 2018/3/5.
 * 总功能类，提供了默认静态类，也可以通过Builder创建实例
 * <p>
 * clickView ：提供文案，提供静态图，有点击事件
 * gifView   ：提供文案，提供GIF图，无点击事件
 */
public class Liquid {
    private static final String TAG = "Liquid";
    private static final int VIEW_LIQUID = R.id.liquid_view;
    private static final LiquidStyle liStyle = LiquidStyle.getDefault();
    private LiquidParams params;

    private Liquid(LiquidParams params) {
        this.params = params;
    }

    /**
     * 显示点击事件布局——param
     */
    public void show() {
        if (params.parentLayout == null) {
            Log.e(TAG, "not found viewGroup");
            return;
        }
        Liquid.clear(params.parentLayout);

        int clickRid;
        if (params.layoutId != null) {
            clickRid = params.layoutId;
        } else {
            if (liStyle.getClickLayoutRes() == null) {
                clickRid = R.layout.liquid_default_layout_error;
            } else {
                clickRid = liStyle.getClickLayoutRes();
            }
        }

        View childView = LayoutInflater.from(params.parentLayout.getContext()).inflate(clickRid, null);
        ViewGroup.LayoutParams mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        childView.setId(VIEW_LIQUID);
        int vIndex = params.parentLayout instanceof LinearLayout ? 0 : -1;
        params.parentLayout.addView(childView, vIndex, mParams);
        ViewUtil.setInfo(childView, params);
    }

    /**
     * 移除网络异常布布局——Actvitiy
     */
    public static void clear(Activity activity) {
        clear(ViewUtil.getContentView(activity));
    }

    /**
     * 移除网络异常布局——ViewGroup
     */
    public static void clear(ViewGroup viewGroup) {
        viewGroup.removeView(viewGroup.findViewById(VIEW_LIQUID));
    }

    /**
     * 建造者类，内部可以使Liquid的构造方法为private
     */
    public static class Builder {
        private LiquidParams params;

        public Builder() {
            params = new LiquidParams();
        }

        public Builder setText(String text) {
            params.text = text;
            return this;
        }

        public Builder setTextColor(int textColor) {
            params.textColor = textColor;
            return this;
        }

        public Builder setTextSize(int textSize) {
            params.textSize = textSize;
            return this;
        }

        public Builder setImg(int imgRes) {
            params.imgRes = imgRes;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            params.layoutId = layoutId;
            return this;
        }

        public Builder asGif() {
            params.asGif = true;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            params.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setClickListener(View.OnClickListener listener) {
            params.clickListener = listener;
            return this;
        }

        public Liquid build(Activity activity) {
            return build(ViewUtil.getContentView(activity));
        }

        public Liquid build(ViewGroup parentLayout) {
            params.parentLayout = parentLayout;
            return new Liquid(params);
        }
    }
}
