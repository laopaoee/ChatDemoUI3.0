package com.example.netbase.factory;

import com.example.netbase.base.IRequestManager;
import com.example.netbase.impl.XutilsManager;

public class RequestFactory {

    public static IRequestManager getRequestManager() {
        return XutilsManager.getInstances();
    }
}
