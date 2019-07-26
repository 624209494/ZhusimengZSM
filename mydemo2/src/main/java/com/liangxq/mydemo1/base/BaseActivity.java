package com.liangxq.mydemo1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.base
 * 文件名：BaseActivity
 * 创建者：liangxq
 * 创建时间：2019/7/25  2:01
 * 描述：TODO
 */
public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity {
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter=createPresenter();
        super.onCreate(savedInstanceState);
        if(mPresenter!=null){
            mPresenter.attach((V) this);
        }
    }

    public void showProgressBar(){

    }
    public void hideProgressBar(){

    }
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
