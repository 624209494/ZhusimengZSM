package com.liangxq.mydemo1.app;

import android.app.Application;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.app
 * 文件名：MyApp
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:28
 * 描述：TODO
 */
public class MyApp extends Application{

    private static MyApp myApp;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }
    public static MyApp getInstance(){

        return myApp;
    }
}
