package com.ly.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yangl.liu on 2017/3/2.
 * 基础的RecyclerView适配
 */

public abstract class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    protected Context mContext;
    protected List<Object> mDatas;

    public BaseRecyclerAdapter(Context mContext, List mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public abstract T onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(T holder, int position);

    @Override
    public int getItemCount() {
        if (mDatas == null) {
            return 0;
        }
        return mDatas.size();
    }

    /**
     * 生成View布局
     */
    protected View initView(ViewGroup parent, int rid) {
        return LayoutInflater.from(mContext).inflate(rid, parent, false);
    }

}
