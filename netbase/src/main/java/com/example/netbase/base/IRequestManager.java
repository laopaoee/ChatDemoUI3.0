package com.example.netbase.base;


public interface IRequestManager {

    public void get(String url, IRequestCallback iRequestCallback);

    public void post(String url, String requestBodyJson, IRequestCallback iRequestCallback);

    public void put(String url, String requestBodyJson, IRequestCallback iRequestCallback);

    public void delete(String url, String requestBodyJson, IRequestCallback iRequestCallback);
}
