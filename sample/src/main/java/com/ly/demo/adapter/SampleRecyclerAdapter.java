package com.ly.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ly.demo.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by yangl.liu on 2017/5/8.
 */
public class SampleRecyclerAdapter extends BaseRecyclerAdapter<SampleRecyclerAdapter.SimHolder> {

    public SampleRecyclerAdapter(Context mContext, List mDatas) {
        super(mContext, mDatas);
    }

    @Override
    @NonNull
    public SimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimHolder(initView(parent, R.layout.item_sample));
    }

    @Override
    public void onBindViewHolder(@NonNull SimHolder viewHolder, int position) {
        viewHolder.textView.setText(mDatas.get(position).toString());
    }

    class SimHolder extends RecyclerView.ViewHolder {
        TextView textView;

        private SimHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}