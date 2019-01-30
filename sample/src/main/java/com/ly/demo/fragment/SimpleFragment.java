package com.ly.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ly.demo.R;
import com.ly.demo.adapter.SampleRecyclerAdapter;
import com.ly.demo.util.SampleUtil;
import com.ly.liquid.Liquid;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class SimpleFragment extends BaselazyLoadFragment {
    private RecyclerView rv;
    private SampleRecyclerAdapter adapter;
    private List<String> mDatas;
    private SwipeRefreshLayout swipe;
    private ViewGroup parentLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_simaple, container, false);
            init();
            initRecy();
            isPrepared = true;
        }
        return mView;
    }

    private void init() {
        parentLayout = findView(R.id.llayout);
        swipe = findView(R.id.swipe);
        rv = findView(R.id.rv);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initRecy() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        adapter = new SampleRecyclerAdapter(mContext, mDatas);
        rv.setLayoutManager(layoutManager);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    /**
     * 懒加载方法
     */
    @Override
    protected void lazyLoad() {
        if (!checkLazy()) {
            loadData();
            isInited = true;
        }
    }

    private void loadData() {
        SampleUtil.showLoading(parentLayout);
        swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                rv.setAdapter(adapter);
                swipe.setRefreshing(false);
                Liquid.clear(parentLayout);
            }
        }, 1000);
    }
}