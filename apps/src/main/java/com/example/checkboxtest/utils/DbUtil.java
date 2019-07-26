package com.example.checkboxtest.utils;

import com.example.checkboxtest.app.MyApp;
import com.example.checkboxtest.bean.DbBean;
import com.example.checkboxtest.dao.DaoMaster;
import com.example.checkboxtest.dao.DaoSession;
import com.example.checkboxtest.dao.DbBeanDao;

import java.util.List;

public class DbUtil {
    private final DaoSession daoSession;

    //  private final DbBeanDao dbBeanDao;

    public DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.app, "a.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        daoSession = daoMaster.newSession();

       // dbBeanDao = daoSession.getDbBeanDao();
    }
    public static DbUtil dbUtil;

    public static DbUtil getDbUtil() {
        if (dbUtil==null){
            synchronized (DbUtil.class){
                if (dbUtil==null){
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }
    public void insert(DbBean dbBean){
        DbBean queryone = queryone(dbBean.getTitle());
        if (queryone==null){
            daoSession.insert(dbBean);
        }

    }
    public DbBean queryone(String title){
        DbBean unique = daoSession.queryBuilder(DbBean.class)
                .where(DbBeanDao.Properties.Title.eq(title))
                .build()
                .unique();
        return unique;
    }
    public void delete(DbBean dbBean){
        daoSession.delete(dbBean);
    }
}
