package com.example.netbase.base;


public interface IRequestCallback {

    public void onSucess(String response);

    public void onError(Throwable throwable);
}
