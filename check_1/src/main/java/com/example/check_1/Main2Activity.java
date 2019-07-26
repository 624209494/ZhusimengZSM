package com.example.check_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.check_1.adapers.RecycAdaper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecyc;
    private RecycAdaper adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initrecyc();
        initdatas();

    }

    private void initdatas() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                final List<Bean.DataBean> results = bean.getData();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adaper.initdata(results);
                    }
                });
            }
        });


    }

    private void initrecyc() {
        mRecyc.setLayoutManager(new LinearLayoutManager(this));
        mRecyc.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        adaper = new RecycAdaper(this);
        mRecyc.setAdapter(adaper);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initView() {
        mRecyc = (RecyclerView) findViewById(R.id.recyc);
    }
}
