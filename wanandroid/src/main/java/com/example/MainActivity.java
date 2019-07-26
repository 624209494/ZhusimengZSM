package com.example;


import com.example.base.BaseActivity;
import com.example.bean.ListData;
import com.example.contract.MainContract;
import com.example.persenter.PersenterImpl;
import com.example.wanandroid.R;

import java.util.List;

public class MainActivity extends BaseActivity<MainContract.MainView, PersenterImpl> implements MainContract.MainView {

    private PersenterImpl persenter;

    @Override
    protected PersenterImpl createPersenter() {
        persenter = new PersenterImpl(this);
        return persenter;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(List<ListData> listData) {

    }

    @Override
    public void OnError(String error) {

    }
}
