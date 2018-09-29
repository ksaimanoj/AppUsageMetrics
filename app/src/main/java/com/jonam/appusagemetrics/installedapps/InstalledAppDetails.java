package com.jonam.appusagemetrics.installedapps;

import android.graphics.drawable.Drawable;

public class InstalledAppDetails {

    String appName;
    Drawable appLogo;

    public InstalledAppDetails(String appName, Drawable appLogo) {
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
