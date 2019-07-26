package com.example.zhusimengzsm.adapers;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class Vpadaper extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> list;
    String [] str = {"专题活动","人气宝贝"};

    public Vpadaper(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];

    }
}
