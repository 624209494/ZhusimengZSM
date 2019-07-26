package com.example.shipei.base;

import android.view.View;

import java.lang.ref.WeakReference;

public class BasePersenter<V> {
    private WeakReference<V> weakReference;


    public V mView;
    public void attach(V view){
        weakReference = new WeakReference<>(view);
        mView = weakReference.get();
    }

    public void detechView(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }

}
