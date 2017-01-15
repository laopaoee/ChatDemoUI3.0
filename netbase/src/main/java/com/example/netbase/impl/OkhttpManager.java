package com.example.netbase.impl;
import com.example.netbase.base.IRequestCallback;
import com.example.netbase.base.IRequestManager;

public class OkhttpManager  implements IRequestManager {

    private static OkhttpManager sOkhttpManager;

    private OkhttpManager() {

    }

    public static OkhttpManager getInstances() {
        if (sOkhttpManager == null) {
            synchronized (OkhttpManager.class) {
                if (sOkhttpManager == null) {
                    sOkhttpManager = new OkhttpManager();
                }
            }
        }
        return sOkhttpManager;
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
