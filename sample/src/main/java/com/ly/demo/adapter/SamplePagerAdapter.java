package com.ly.demo.adapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class SamplePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titles;

    public SamplePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles.get(position);
    }
}
