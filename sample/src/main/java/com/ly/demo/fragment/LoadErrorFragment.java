package com.ly.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ly.demo.R;
import com.ly.demo.adapter.SimAdapter;
import com.ly.liquid.Liquid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class LoadErrorFragment extends BaseFragment {
    private View mView;
    private RecyclerView rv;
    private SimAdapter adapter;
    private List<String> mDatas;
    private SwipeRefreshLayout swipe;
    private boolean flag;
    private ViewGroup paretLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_simaple, container, false);
            init();
            initRecy();
            showErrorView();
        }
        return mView;
    }

    private void init() {
                paretLayout = mView.findViewById(R.id.llayout);
        swipe = mView.findViewById(R.id.swipe);
        rv = mView.findViewById(R.id.rv);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initRecy() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new SimAdapter(getContext(), mDatas);
        rv.setLayoutManager(layoutManager);
        swipe.setColorSchemeColors(0xff3f51b5);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }


    private void showErrorView() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        };

        new Liquid.Builder()
                .setClickListener(listener)
                .setBackgroundColor(0xffffffff)
                .build(paretLayout)
                .showClickView();
    }

    private void loadData() {
        Liquid.showLoadingView(paretLayout);
        swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    Liquid.clear(paretLayout);
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
        Liquid.showClickView(paretLayout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }
}


















