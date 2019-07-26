package model;

import com.example.zhusimengzsm.bean.Bean1;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ModleImpl {
    public void getdata(final CallBacks callBacks){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://172.16.59.44:8080/test/a/1.json")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBacks.getdataNo(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                Bean1 bean1 = gson.fromJson(str, Bean1.class);
                List<Bean1.ResultBean.DataBean> data = bean1.getResult().getData();
                callBacks.getdataOK(data);
            }
        });
    }
}
