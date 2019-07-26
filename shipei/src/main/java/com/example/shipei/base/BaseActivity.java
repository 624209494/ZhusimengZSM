package com.example.shipei.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V,P extends BasePersenter<V>> extends SimpleActivity {
    public P mPersenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPersenter =createPersneter();
        super.onCreate(savedInstanceState);
        if (mPersenter!=null){
            mPersenter.attach((V) this);
        }
    }

    public void showProgressBar(){

    }
    public void hideProgressBar(){

    }

    protected abstract P createPersneter();
}
