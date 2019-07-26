package com.example.bean;

import com.example.app.MyApp;
import com.jy.zsm.db.DaoSession;
import com.jy.zsm.db.DbBeanDao;

public class UTILSSSS {

    private static     DaoSession daoSession = MyApp.getDaoSession();
    public static void insert(DbBean dbBean){
        DbBean queryone = queryone(dbBean.getTitle());
        if (queryone==null){
            daoSession.insert(dbBean);
        }

    }
    public static DbBean queryone(String title){
        DbBean unique = daoSession.queryBuilder(DbBean.class)
                .where(DbBeanDao.Properties.Title.eq(title))
                .build()
                .unique();
        return unique;
    }
    public static  void delete(DbBean dbBean){
        daoSession.delete(dbBean);
    }
}
