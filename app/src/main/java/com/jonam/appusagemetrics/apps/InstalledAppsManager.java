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
            AppDetails appDetails = new AppDetails(
                    applicationInfo.loadLabel(context.getPackageManager()).toString(),
                    applicationInfo.loadIcon(context.getPackageManager())
            );
            appDetailsList.add(appDetails);
        }
    }

    public List<AppDetails> getAppDetailsList() {
        List<AppDetails> filteredList = filterApps();
        return filteredList;
    }

    private List<AppDetails> filterApps() {
        List<AppDetails> filteredList = new ArrayList<>();
        for(AppDetails appDetails : appDetailsList)
        {
            if(!appDetails.getAppName().startsWith("com."))
                filteredList.add(appDetails);
        }
        return filteredList;
    }
}
