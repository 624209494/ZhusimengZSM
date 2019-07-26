package com.example.shipei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRes;

    /**
     * Hello World!
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        CrashReport.initCrashReport(getApplicationContext(), "05962e5bbb", true);


    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    private void initView() {
        mRes = (Button) findViewById(R.id.res);
        mRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.res:
                CrashReport.testJavaCrash();
                break;
        }
    }
}
