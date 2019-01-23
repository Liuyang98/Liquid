package com.ly.demo.interfaces;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ly.liquid.interfaces.LiquidLoader;

public class SampleLoader implements LiquidLoader {

    @Override
    public void load(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, int url) {
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void loadGif(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void loadGif(ImageView imageView, int url) {
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
