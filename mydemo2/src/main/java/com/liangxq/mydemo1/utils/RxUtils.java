package com.liangxq.mydemo1.utils;

import com.liangxq.mydemo1.bean.BaseResponse;
import com.liangxq.mydemo1.http.ApiException;
import com.liangxq.mydemo1.http.HttpManager;
import com.liangxq.mydemo1.http.MyServer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.utils
 * 文件名：RxUtils
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:50
 * 描述：TODO
 */
public class RxUtils {
    //简化线程切换的代码
    public static <T>ObservableTransformer<T,T> rxScheduleThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    //将数据转换成我们想要的数据
    public static <T> ObservableTransformer<BaseResponse<T>,T> changeResult(){
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final BaseResponse<T> tBaseResponse) throws Exception {
                        if(tBaseResponse.getErrorCode()==0){
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                                    try{
                                        emitter.onNext(tBaseResponse.getData());
                                        emitter.onComplete();
                                    }catch (Exception e){
                                        emitter.onError(e);
                                    }
                                }
                            });
                        }else{
                           return Observable.error(new ApiException(tBaseResponse.getErrorCode(),tBaseResponse.getErrorMsg()));
                        }
                    }
                });
            }
        };
    }

}
