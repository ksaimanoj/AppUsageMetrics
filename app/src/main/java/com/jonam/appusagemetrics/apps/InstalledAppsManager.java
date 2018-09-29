package com.jonam.appusagemetrics.apps;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class InstalledAppsManager {

    Context context;
    List<ApplicationInfo> applicationInfoList;
    List<AppDetails> appDetailsList = new ArrayList<>();

    public InstalledAppsManager(Context context) {
        this.context = context;
        populateAppDetailsList();
    }

    private void populateAppDetailsList() {
        applicationInfoList = context.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        populateInstalledAppNamesList();
    }

    private void populateInstalledAppNamesList() {
        for(ApplicationInfo applicationInfo : applicationInfoList)
        {
            if(satifiesFilterConditions(applicationInfo))
            {
                appDetailsList.add(new AppDetails(
                        applicationInfo.loadLabel(context.getPackageManager()).toString(),
                        applicationInfo.loadIcon(context.getPackageManager())
                ));
            }
        }
    }

    // TODO: Debug the different flags.
    private boolean satifiesFilterConditions(ApplicationInfo applicationInfo) {
        //return (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        return !applicationInfo.loadLabel(context.getPackageManager()).toString().startsWith("com.");
    }

    public List<AppDetails> getAppDetailsList() {
        return appDetailsList;
    }

}
