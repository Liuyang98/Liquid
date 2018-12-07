package com.ly.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ly.demo.R;
import com.ly.demo.adapter.SampleRecyclerAdapter;
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
public class LoadErrorFragment extends BaseFragment {
    private RecyclerView rv;
    private SampleRecyclerAdapter adapter;
    private SwipeRefreshLayout swipe;
    private ViewGroup paretLayout;
    private boolean flag;
    private List<String> mDatas;

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
        rv = findView(R.id.rv);
        swipe = findView(R.id.swipe);
        paretLayout = findView(R.id.llayout);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initRecy() {
        adapter = new SampleRecyclerAdapter(getContext(), mDatas);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
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