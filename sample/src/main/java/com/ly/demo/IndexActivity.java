package com.ly.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ly.demo.activity.FragmentMuleipleActivity;
import com.ly.demo.activity.FragmentSingleActivity;
import com.ly.demo.activity.FragmentViewPagerActiviy;
import com.ly.demo.activity.NormalActivity;
import com.ly.demo.activity.ViewGroupActivity;

public class IndexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void inViewGroup(View view) {
        to(ViewGroupActivity.class);
    }

    public void inActivity(View view) {
        to(NormalActivity.class);
    }

    public void inFragmentSingle(View view) {
        to(FragmentSingleActivity.class);
    }

    public void inFragmentMuleiple(View view) {
        to(FragmentMuleipleActivity.class);
    }

    public void inFragmentViewPager(View view) {
        to(FragmentViewPagerActiviy.class);
    }

    private void to(Class cls) {
        startActivity(new Intent(this, cls));
    }
}
