package com.example.app;

import android.app.Application;

import com.jy.zsm.db.DaoMaster;
import com.jy.zsm.db.DaoSession;

public class MyApp extends Application {
    public static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "a.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }

}
