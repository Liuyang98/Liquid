package com.ly.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by yangl.liu on 2017/3/2.
 * 基础的RecyclerView适配
 */

public abstract class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    protected Context mContext;
    protected List<Object> mDatas;

    public BaseRecyclerAdapter(Context mContext, List<Object> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    @NonNull
    public abstract T onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(@NonNull T holder, int position);

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
