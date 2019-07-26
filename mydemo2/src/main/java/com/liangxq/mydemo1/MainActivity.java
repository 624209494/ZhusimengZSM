package com.liangxq.mydemo1;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.liangxq.mydemo1.adapers.RecycAdaper;
import com.liangxq.mydemo1.base.BaseActivity;
import com.liangxq.mydemo1.bean.BaseResponse;
import com.liangxq.mydemo1.bean.ListData;
import com.liangxq.mydemo1.contract.MainContract;
import com.liangxq.mydemo1.http.HttpManager;
import com.liangxq.mydemo1.http.MyServer;
import com.liangxq.mydemo1.presenter.PersenterImpl;
import com.liangxq.mydemo1.utils.RxUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity<MainContract.MainView, PersenterImpl> implements MainContract.MainView {


    @BindView(R.id.recyc)
    RecyclerView recyc;
    private PersenterImpl persenter;
    private RecycAdaper adaper;

    @Override
    protected void initViewAndData() {
        recyc.setLayoutManager(new LinearLayoutManager(this));
        recyc.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        adaper = new RecycAdaper(this);
        recyc.setAdapter(adaper);



        persenter.http();
        initdata();
    }

    public void initdata(){
        HttpManager.getInstance().getServer(MyServer.class)
                .get("wxarticle/chapters/json")
                .compose(RxUtils.<BaseResponse<List<ListData>>>rxScheduleThread())
                .compose(RxUtils.<List<ListData>>changeResult())
                .subscribe(new Consumer<List<ListData>>() {
                    @Override
                    public void accept(List<ListData> listData) throws Exception {
                        adaper.initdata(listData);
                    }
                });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected PersenterImpl createPresenter() {
        persenter = new PersenterImpl(this);
        return persenter;

    }

    @Override
    public void showSuccess(List<ListData> listData) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
