package com.example.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V,P extends BasePersenter<V>>  extends SimpleActivity {
    public  P mPersenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPersenter= createPersenter();

        if (mPersenter != null){
            mPersenter.accach((V) this);
        }

    }

    protected abstract P createPersenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPersenter!=null){
            mPersenter.detach();
        }
    }
}
