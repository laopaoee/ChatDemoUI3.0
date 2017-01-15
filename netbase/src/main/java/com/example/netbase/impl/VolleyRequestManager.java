package com.example.netbase.impl;


import com.example.netbase.base.IRequestCallback;
import com.example.netbase.base.IRequestManager;

public class VolleyRequestManager implements IRequestManager {


    private static VolleyRequestManager sVolleyRequestManager;

    private VolleyRequestManager() {
    }

    public static VolleyRequestManager getInstances() {
        if (sVolleyRequestManager == null) {
            synchronized (VolleyRequestManager.class) {
                if (sVolleyRequestManager == null) {
                    sVolleyRequestManager = new VolleyRequestManager();
                }
            }
        }
        return sVolleyRequestManager;
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
