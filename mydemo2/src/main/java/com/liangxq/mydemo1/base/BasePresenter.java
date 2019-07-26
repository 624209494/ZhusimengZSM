package com.liangxq.mydemo1.base;

import java.lang.ref.WeakReference;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.base
 * 文件名：BasePresenter
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:13
 * 描述：TODO
 */
public class BasePresenter<V> {
    private WeakReference<V> weakReference;

    public V mView;

    public void attach(V view){
        weakReference=new WeakReference<>(view);
        mView= weakReference.get();
    }

    public void detachView(){
        if(weakReference!=null){
            weakReference.clear();
        }
    }
}
