package com.example.netbase.impl;

import com.example.netbase.base.IRequestCallback;
import com.example.netbase.base.IRequestManager;

public class RetrofitManager  implements IRequestManager {

    private static RetrofitManager sRetrofitManager;

    private RetrofitManager() {
    }

    public static RetrofitManager getInstances() {
        if (sRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (sRetrofitManager == null) {
                    sRetrofitManager = new RetrofitManager();
                }
            }
        }
        return sRetrofitManager;
    }


    @Override
    public void get(String url, IRequestCallback iRequestCallback) {

    }

    @Override
    public void post(String url, String requestBodyJson, IRequestCallback iRequestCallback) {

    }

    @Override
    public void put(String url, String requestBodyJson, IRequestCallback iRequestCallback) {

    }

    @Override
    public void delete(String url, String requestBodyJson, IRequestCallback iRequestCallback) {

    }
}
