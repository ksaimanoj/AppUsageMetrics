package com.jonam.appusagemetrics.apps;

import android.graphics.drawable.Drawable;

public class AppDetails {

    String appName;
    Drawable appLogo;

    public AppDetails(String appName, Drawable appLogo) {
        this.appName = appName;
        this.appLogo = appLogo;
    }

    public String getAppName() {
        return appName;
    }

    public Drawable getAppLogo() {
        return appLogo;
    }
}
