package com.example.base;

import java.lang.ref.WeakReference;

public class BasePersenter<V> {
    private WeakReference<V> weakReference;
    private V mview;
    public void accach(V view){
        weakReference  = new WeakReference<>(view);
        mview = weakReference.get();
    }


    public void detach(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }









}
