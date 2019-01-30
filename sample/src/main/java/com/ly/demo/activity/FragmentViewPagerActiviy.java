package com.ly.demo.activity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.ly.demo.R;
import com.ly.demo.adapter.SamplePagerAdapter;
import com.ly.demo.fragment.LoadErrorFragment;
import com.ly.demo.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by yangl.liu on 2018/3/7.
 * ViewPager与Fragment结合的场景
 */
public class FragmentViewPagerActiviy extends AppCompatActivity {
    private ViewPager vp;
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_fragment);
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
        vp.setAdapter(new SamplePagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
        tabLayout.setupWithViewPager(vp);
    }
}