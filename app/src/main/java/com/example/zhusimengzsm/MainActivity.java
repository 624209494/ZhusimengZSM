package com.example.zhusimengzsm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.zhusimengzsm.fragments.Fragmentshow;


public class MainActivity extends AppCompatActivity {


    private RelativeLayout mVp;
    /**
     * 主页
     */
    private RadioButton mBtn1;
    /**
     * 发现
     */
    private RadioButton mBtn2;
    /**
     * 成长
     */
    private RadioButton mBtn3;
    /**
     * 我的
     */
    private RadioButton mBtn4;
    private RadioGroup mRadioGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragmentshow fragmentshow = new Fragmentshow();
        fragmentTransaction.add(R.id.vp,fragmentshow);
        fragmentTransaction.show(fragmentshow);
        fragmentTransaction.commit();
    }

    private void initView() {
        mVp = (RelativeLayout) findViewById(R.id.vp);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mBtn4 = (RadioButton) findViewById(R.id.btn4);
        mRadioGroups = (RadioGroup) findViewById(R.id.radioGroups);


    }


}
