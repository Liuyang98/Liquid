package com.ly.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by yangl.liu on 2017/4/19.
 * 基础Fragment
 */

public class BaseFragment extends Fragment {
    private static final String TYPE = "TYPE";
    protected Context mContext;
    protected View mView;

    protected <T extends View> T findView(int id) {
        return mView.findViewById(id);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    protected int getType() {
        if (getArguments() != null)
            return getArguments().getInt(BaseFragment.TYPE, -1);
        else return -1;
    }

    public BaseFragment setType(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseFragment.TYPE, type);
        setArguments(bundle);
        return this;
    }
}
