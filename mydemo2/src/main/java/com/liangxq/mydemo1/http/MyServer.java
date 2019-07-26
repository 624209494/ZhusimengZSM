package com.liangxq.mydemo1.http;


import com.liangxq.mydemo1.bean.BaseResponse;
import com.liangxq.mydemo1.bean.ListData;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.http
 * 文件名：MyServer
 * 创建者：liangxq
 * 创建时间：2019/7/24  20:46
 * 描述：TODO
 */
public interface MyServer {

    @GET
    Observable<BaseResponse<List<ListData>>> get(@Url String url);


}
