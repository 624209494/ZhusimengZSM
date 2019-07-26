package com.liangxq.mydemo1.base;

import com.liangxq.mydemo1.http.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.base
 * 文件名：BaseObserver
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:48
 * 描述：TODO
 */
public abstract class BaseObserver<T> implements Observer<T> {

    //管理每次网络请求
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        //网络请求成功
        if (e instanceof ApiException) {
             ApiException apiException= (ApiException) e;
            int errorCode = apiException.getErrorCode();
            switch (errorCode){
                case 1:
            }
            error(apiException.getErrorMsg());
            //网络请求失败
        }else if(e instanceof HttpException){
            error(e.getMessage());
        }
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void onComplete() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    abstract <T> void onSuccess(T data);

    abstract<T> void error(T  error);
}
