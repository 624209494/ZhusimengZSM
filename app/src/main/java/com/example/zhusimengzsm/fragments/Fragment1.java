package com.example.zhusimengzsm.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhusimengzsm.R;
import com.example.zhusimengzsm.adapers.RecycAdaper;
import com.example.zhusimengzsm.bean.Bean1;

import java.util.List;

import persneter.PersenterImpl;
import view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements IView, View.OnClickListener {


    private View view;
    private RecyclerView mRecyc1;
    private RecycAdaper adaper;
    private ScrollView mScro;
    private ImageView mImg2;
    private ImageView mImg3;
    private ImageView mImg4;
    private TabLayout mTable1;
    private RecyclerView mRecyc2;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(inflate);
        initrecyc();
        initdatas();

        return inflate;
    }

    private void initdatas() {
        PersenterImpl persenter = new PersenterImpl(this);
        persenter.getdatas();

    }

    private void initrecyc() {



        mRecyc2.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adaper = new RecycAdaper(getActivity());
        mRecyc2.setAdapter(adaper);

        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyc1.setAdapter(adaper);

    }

    private void initView(View inflate) {
        mRecyc1 = (RecyclerView) inflate.findViewById(R.id.recyc1);

        mRecyc1.setOnClickListener(this);
        mImg2 = (ImageView) inflate.findViewById(R.id.img2);
        mImg3 = (ImageView) inflate.findViewById(R.id.img3);
        mImg4 = (ImageView) inflate.findViewById(R.id.img4);

        mRecyc2 = (RecyclerView) inflate.findViewById(R.id.recyc2);






    }

    @SuppressLint("CheckResult")
    @Override
    public void getdataOK(final List<Bean1.ResultBean.DataBean> list) {
        adaper.getdata(list);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RoundedCorners roundedCorners = new RoundedCorners(20);
                RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
                Glide.with(getActivity()).load(list.get(0).getThumbnail_pic_s()).apply(requestOptions).into(mImg2);
                Glide.with(getActivity()).load(list.get(1).getThumbnail_pic_s()).apply(requestOptions).into(mImg3);
                Glide.with(getActivity()).load(list.get(2).getThumbnail_pic_s()).apply(requestOptions).into(mImg4);
            }
        });

    }

    @Override
    public void getdataNO(String error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recyc1:
                break;
        }
    }
}
