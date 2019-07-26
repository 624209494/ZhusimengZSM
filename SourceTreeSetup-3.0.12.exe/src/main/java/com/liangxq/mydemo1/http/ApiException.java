package com.liangxq.mydemo1.http;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.mydemo1.base
 * 文件名：ApiException
 * 创建者：liangxq
 * 创建时间：2019/7/24  2:46
 * 描述：TODO
 */
public class ApiException extends Throwable{
    private int errorCode;
    private String errorMsg;
    public ApiException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
