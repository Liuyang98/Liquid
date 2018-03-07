package com.ly.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class SimPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titles;

    public SimPagerAdapter(FragmentManager fm, List fragmentList, List<String> titles) {
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
        CharSequence quence = titles == null ? " " : titles.get(position);
        return quence;
    }
}
