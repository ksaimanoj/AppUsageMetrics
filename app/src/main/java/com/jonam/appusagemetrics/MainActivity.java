package com.jonam.appusagemetrics;

import android.content.pm.*;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.jonam.appusagemetrics.installedapps.InstalledAppDetails;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.installedAppsListView);
        List<InstalledAppDetails> installedApps = getInstalledAppDetailsList();
        ArrayAdapter adapter = new InstalledAppListAdapater(
                getBaseContext(), android.R.layout.simple_list_item_1 , installedApps);
        listView.setAdapter(adapter);
    }

    @NonNull
    private List<InstalledAppDetails> getInstalledAppDetailsList() {
        List<ApplicationInfo> installedAppsList = queryPackageManagerForListOfInstalledApps();
        return populateInstalledAppNamesList(installedAppsList);
    }

    private List<ApplicationInfo> queryPackageManagerForListOfInstalledApps() {
        return getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }

    @NonNull
    private List<InstalledAppDetails> populateInstalledAppNamesList(List<ApplicationInfo> installedAppsList) {
        List<InstalledAppDetails> installedApps = new ArrayList<>();
        for(ApplicationInfo applicationInfo : installedAppsList)
        {
            InstalledAppDetails appDetails = new InstalledAppDetails(
                    applicationInfo.loadLabel(getPackageManager()).toString(),
                    applicationInfo.loadIcon(getPackageManager())
            );
            installedApps.add(appDetails);
        }
        return installedApps;
    }
}
