package com.ly.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ly.demo.adapter.SimPagerAdapter;
import com.ly.demo.fragment.LoadErrorFragment;
import com.ly.demo.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */
public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private List<String> titleList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        vp = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tablayout);
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        fragmentList.add(new LoadErrorFragment());
        titleList.add("页面z:");
        for (int i = 0; i < 6; i++) {
            fragmentList.add(new SimpleFragment().setType(i));
            titleList.add("页面:" + i);
        }
        vp.setAdapter(new SimPagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
        tabLayout.setupWithViewPager(vp);
        vp.setVisibility(View.VISIBLE);

    }
}
