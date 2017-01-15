package com.example.netbase.impl;

import com.example.netbase.base.IRequestCallback;
import com.example.netbase.base.IRequestManager;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class XutilsManager implements IRequestManager {

    private static XutilsManager sXutilsManager;

    private XutilsManager() {

    }

    public static XutilsManager getInstances() {
        if (sXutilsManager == null) {
            synchronized (XutilsManager.class) {
                if (sXutilsManager == null) {
                    sXutilsManager = new XutilsManager();
                }
            }
        }
        return sXutilsManager;
    }


    @Override
    public void get(String url, final IRequestCallback iRequestCallback) {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                iRequestCallback.onSucess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                iRequestCallback.onError(ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
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
