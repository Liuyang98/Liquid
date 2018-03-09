package com.ly.demo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ly.demo.R;
import com.ly.demo.adapter.SimAdapter;
import com.ly.liquid.Liquid;
import com.ly.liquid.LiquidUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class LoadErrorFragment extends BaseFragment {
    private ViewGroup view;
    private View mView;
    private RecyclerView rv;
    private SimAdapter adapter;
    private List<String> mDatas;
    private SwipeRefreshLayout swipe;
    private boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_simaple, container, false);
            init();
            initRecy();
            showCustomView();
        }
        return mView;
    }

    private void init() {
        view = (ViewGroup) mView;
        swipe = view.findViewById(R.id.swipe);
        rv = view.findViewById(R.id.rv);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initRecy() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new SimAdapter(getContext(), mDatas);
        rv.setLayoutManager(layoutManager);
        swipe.setColorSchemeColors(0xFF3F51B5);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

    }


    private void showCustomView() {
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Liquid.removeErrorView((ViewGroup) mView);
            }
        };

//        showCustomView
/*       new Liquid.Builder()
                .setText("测试文案")
                .setClickListener(listener)
                .build((ViewGroup) mView)
                .showCustomView();*/
        Liquid.showCustomView((ViewGroup) mView);
//        Liquid.showErrorView((Activity) mContext,listener);
    }

    private void loadData() {
        Liquid.showLoadingView(view);
        swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    LiquidUtil.removeAllView(view);
                    rv.setAdapter(adapter);
                    swipe.setRefreshing(false);
                } else {
                    showError();
                }
                flag = !flag;
            }
        }, 500);
    }

    private void showError() {
        Liquid.showErrorView(view, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }
}


















