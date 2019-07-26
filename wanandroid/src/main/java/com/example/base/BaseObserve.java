package com.example.base;

import com.example.http.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserve<T> implements Observer<T> {

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
        if (e instanceof ApiException){
            ApiException apiException = (ApiException) e;
            int errorCode = apiException.getErrorCode();
            switch (errorCode) {
            		case 1:

            			break;

            		default:
            			break;
            		}
            		onsuccess(apiException.getErrorMsg());

        }else if (e instanceof HttpException){
            onerroe(e.getMessage());
        }
        if (compositeDisposable == null){
            compositeDisposable.clear();
        }
    }

    @Override
    public void onComplete() {
        if (compositeDisposable == null){
            compositeDisposable.clear();
        }
    }

    abstract <T> void onsuccess(T data);

    abstract  <T> void onerroe(T error);
}
