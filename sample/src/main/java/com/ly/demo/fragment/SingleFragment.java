package com.ly.demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ly.demo.R;
import com.ly.liquid.Liquid;

public class SingleFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_single, container, false);
            init();
        }
        return mView;
    }

    private void init() {
        Liquid.showClickView((ViewGroup) mView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
            }
        });
    }

    private void showLoading() {
        Liquid.showLoadingView((ViewGroup) mView);
        mView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Liquid.clear((ViewGroup) mView);
            }
        }, 1500);
    }
}
