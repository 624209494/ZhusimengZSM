package com.example.demo1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.demo1.fragments.Fragment1;

public class MainActivity extends AppCompatActivity {

    /**
     * APP潜客
     */
    private RadioButton mRadio1;
    /**
     * 微聊
     */
    private RadioButton mRadio2;
    /**
     * 微信用户
     */
    private RadioButton mRadio3;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initfm();

    }

    private void initfm() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();

        transaction.add(R.id.relativeLayout,fragment1);
        transaction.show(fragment1);
        transaction.commit();

    }





    private void initView() {
        mRadio1 = (RadioButton) findViewById(R.id.Radio1);
        mRadio2 = (RadioButton) findViewById(R.id.Radio2);
        mRadio3 = (RadioButton) findViewById(R.id.Radio3);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }
}
