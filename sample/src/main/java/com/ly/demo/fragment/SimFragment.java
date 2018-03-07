package com.ly.demo.fragment;

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
import com.ly.liquid.TransLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class SimFragment extends BaselazyLoadFragment {
    private View view;
    private RecyclerView rv;
    private SimAdapter adapter;
    private List<String> mDatas;
    private SwipeRefreshLayout swipe;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_simaple, container, false);
            init();
            initRecy();
            isPrepared = true;
        }
        return view;
    }

    private void init() {
        swipe = view.findViewById(R.id.swipe);
        rv = view.findViewById(R.id.rv);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initRecy() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        adapter = new SimAdapter(mContext, mDatas);
        rv.setLayoutManager(layoutManager);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if (!checkLazy()) {
            loadData();
            isInited = true;
        }
    }

    private void loadData() {
        TransLayoutManager.showLoadingView(getActivity(), (ViewGroup) view);
        swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                rv.setAdapter(adapter);
                swipe.setRefreshing(false);
                TransLayoutManager.removeLoadingView((ViewGroup) view);
            }
        }, 1000);
    }

}


















