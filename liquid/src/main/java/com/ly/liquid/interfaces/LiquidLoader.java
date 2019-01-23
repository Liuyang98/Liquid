package com.ly.liquid.interfaces;

import android.widget.ImageView;

public interface LiquidLoader {

    void load(ImageView imageView, String url);

    void load(ImageView imageView, int url);

    void loadGif(ImageView imageView, String url);

    void loadGif(ImageView imageView, int url);
}