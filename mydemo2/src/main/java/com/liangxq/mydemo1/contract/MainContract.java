package com.liangxq.mydemo1.contract;

import com.liangxq.mydemo1.bean.ListData;

import java.util.List;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.contract
 * 文件名：MainContract
 * 创建者：liangxq
 * 创建时间：2019/7/25  2:49
 * 描述：TODO
 */
public interface MainContract {

    interface MainView{

        void showSuccess(List<ListData>listData);

        void showError(String error);
    }


    interface MainPresenter{
        void http();
    }


    interface MainModle{
        interface CallBack{
            void showSuccess(List<ListData>listData);

            void showError(String error);
        }
        void getData(CallBack callBack);
    }
}
