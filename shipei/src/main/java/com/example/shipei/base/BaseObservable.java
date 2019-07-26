package com.example.shipei.base;

import android.app.Application;

import com.example.shipei.http.ApiException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObservable<T> implements Observer<T> {

    // CompositeDisposable
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {
        //  w网络请求成功
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            int errorCode = apiException.getErrorCode();
            switch (errorCode) {
            		case 1:

            			break;

            		default:
            			break;
            		}
            OnErrors(apiException.getErrorMsg());
            //网络请求失败
        }else if (e instanceof HttpException){
            OnErrors(e.getMessage());
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

    abstract <T> void OnSuccess(T data);

    abstract <T> void OnErrors(T error);
}
