package com.example.zhusimengzsm.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhusimengzsm.R;
import com.example.zhusimengzsm.adapers.Vpadaper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentshow extends Fragment {


    private View view;
    private TabLayout mTable;
    private ViewPager mVps;
    private ArrayList<Fragment> list;

    public Fragmentshow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragmentshow, container, false);
        initView(inflate);
        initfm();
        return inflate;
    }

    private void initfm() {
        FragmentManager fm = getChildFragmentManager();
        list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        list.add(fragment1);

        Vpadaper vpadaper = new Vpadaper(fm, list);
        mVps.setAdapter(vpadaper);

        mTable.setupWithViewPager(mVps);


    }

    private void initView(View inflate) {
        mTable = (TabLayout) inflate.findViewById(R.id.table);
        mVps = (ViewPager) inflate.findViewById(R.id.vps);
    }
}
