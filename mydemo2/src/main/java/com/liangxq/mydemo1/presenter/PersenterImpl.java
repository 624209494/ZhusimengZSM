package com.liangxq.mydemo1.presenter;

import com.liangxq.mydemo1.MainActivity;
import com.liangxq.mydemo1.base.BasePresenter;
import com.liangxq.mydemo1.bean.ListData;
import com.liangxq.mydemo1.contract.MainContract;
import com.liangxq.mydemo1.modle.ModleImpl;

import java.util.List;

public class PersenterImpl extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter{

    private final ModleImpl modle;

    public PersenterImpl(MainContract.MainView mainActivity) {
        modle = new ModleImpl();
        this.mView = mainActivity;
    }
    @Override
    public void http() {
        modle.getData(new MainContract.MainModle.CallBack() {
            @Override
            public void showSuccess(List<ListData> listData) {
                mView.showSuccess(listData);
            }

            @Override
            public void showError(String error) {
                mView.showError(error);
            }
        });
    }
}
