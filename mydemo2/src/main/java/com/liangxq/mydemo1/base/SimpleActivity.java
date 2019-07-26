package com.liangxq.mydemo1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.base
 * 文件名：SimpleActivity
 * 创建者：liangxq
 * 创建时间：2019/7/25  1:56
 * 描述：TODO
 */
public abstract class SimpleActivity extends AppCompatActivity{
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayout());
        unbinder = ButterKnife.bind(this);
     //   EventBus.getDefault().register(this);
        initViewAndData();
    }

    protected abstract void initViewAndData();

    protected abstract int createLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
      //  EventBus.getDefault().unregister(this);
    }
}
