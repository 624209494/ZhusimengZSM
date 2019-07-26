package com.liangxq.mydemo1.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.utils
 * 文件名：HttpUtils
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:31
 * 描述：TODO
 */
public class HttpUtils {

    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }


}
