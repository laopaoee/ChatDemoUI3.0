package com.example.netbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.netbase.base.IRequestCallback;
import com.example.netbase.base.IRequestManager;
import com.example.netbase.factory.RequestFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IRequestManager iRequestManager = RequestFactory.getRequestManager();
        iRequestManager.get("https://www.baidu.com", new IRequestCallback() {

            @Override
            public void onSucess(String response) {
                System.out.println("网络访问成功" + ":::::::::" + response);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("网络访问失败" + ":::::::::" + throwable.toString());
            }
        });
    }
}
