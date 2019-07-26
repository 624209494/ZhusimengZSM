package com.example.demo1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo1.R;
import com.example.demo1.adapers.RecycAdaper;
import com.example.demo1.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private RecyclerView mRecyc;
    private RecycAdaper adaper;

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
        initdata();


        return inflate;
    }

    private void initdata() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                final List<Bean.ResultsBean> results = bean.getResults();


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adaper.initdata(results);
                    }
                });
            }
        });
    }

    private void initrecyc() {
        mRecyc.setLayoutManager(new LinearLayoutManager(getActivity()));

        adaper = new RecycAdaper(getActivity());
        mRecyc.setAdapter(adaper);



    }

    private void initView(View inflate) {
        mRecyc = (RecyclerView) inflate.findViewById(R.id.recyc);
    }
}
