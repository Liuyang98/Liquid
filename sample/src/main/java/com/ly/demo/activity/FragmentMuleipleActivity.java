package com.ly.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ly.demo.R;
import com.ly.demo.fragment.MuleipleFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 多个Fragment切换
 */
public class FragmentMuleipleActivity extends AppCompatActivity implements View.OnClickListener {
    private int lastPosition;
    private List<TextView> textViews;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muleiple_fragment);

        init();
    }

    private void init() {
        lastPosition = 0;
        textViews = new ArrayList<>();
        fragments = new ArrayList<>();
        int[] ids = new int[]{R.id.tv_bottom1, R.id.tv_bottom2, R.id.tv_bottom3, R.id.tv_bottom4};
        for (int i = 0; i < ids.length; i++) {
            textViews.add((TextView) findViewById(ids[i]));
            textViews.get(i).setOnClickListener(this);
            fragments.add(new MuleipleFragment().setType(i + 1));
        }
        textViews.get(lastPosition).setTextColor(0xffff0000);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_muleiple, fragments.get(lastPosition)).commit();
    }

    /**
     * 切换Fragment
     *
     * @param p fragment坐标
     */
    public void insertFragment(int p) {
        if (p != lastPosition) {
            FragmentTransaction fragmentBegin = getSupportFragmentManager().beginTransaction().hide(fragments.get(lastPosition));
            if (fragments.get(p).isAdded()) {
                fragmentBegin.show(fragments.get(p)).commitAllowingStateLoss();
            } else {
                fragmentBegin.add(R.id.frame_muleiple, fragments.get(p)).commitAllowingStateLoss();
            }
            textViews.get(p).setTextColor(0xffff0000);
            textViews.get(lastPosition).setTextColor(0xff333333);
            lastPosition = p;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_bottom1:
                insertFragment(0);
                break;
            case R.id.tv_bottom2:
                insertFragment(1);
                break;
            case R.id.tv_bottom3:
                insertFragment(2);
                break;
            case R.id.tv_bottom4:
                insertFragment(3);
                break;
        }
    }
}
