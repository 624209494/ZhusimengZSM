package com.example.shipei.contract;

import com.example.shipei.bean.ListData;

import java.util.List;

import javax.security.auth.callback.Callback;

public interface MainContract {

    interface MainView{
        void showSuccess(List<ListData> listData);

        void showError(String error);
    }


    interface MainPersenter{
        void http();
    }


    interface MainModle{
        interface CallBack{
            void showSuccess(List<ListData> listData);

            void showError(String error);
        }
        void getdata(Callback callback);
    }


}
