package com.example.bean;

import android.support.v7.widget.RecyclerView;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id
    private Long id;
    private String title;
    @Generated(hash = 432178177)
    public DbBean(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }




}
