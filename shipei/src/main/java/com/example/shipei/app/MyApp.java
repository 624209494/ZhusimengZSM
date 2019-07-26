package com.example.shipei.app;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {
    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "5d38775c570df3b5af0009ad",  "wanandroid", UMConfigure.DEVICE_TYPE_PHONE,  null);
        //参数: context(上下文);appkey(应用唯一标识);channel(自定义名称);UMConfigure.DEVICE_TYPE_PHONE(手机);pushSecret(推送功能的密钥,无集成填null)
        myApp = this;
    }

    public static MyApp getInstance(){
        return myApp;
    }

}
