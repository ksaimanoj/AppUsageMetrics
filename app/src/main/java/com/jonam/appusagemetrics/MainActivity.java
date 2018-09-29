package com.jonam.appusagemetrics;

import android.content.pm.*;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.installedAppsListView);
        List<String> installedApps = getInstalledAppNamesList();
        ArrayAdapter adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1 , installedApps);
        listView.setAdapter(adapter);
    }

    @NonNull
    private List<String> getInstalledAppNamesList() {
        List<ApplicationInfo> installedAppsList = queryPackageManagerForListOfInstalledApps();
        return populateInstalledAppNamesList(installedAppsList);
    }

    private List<ApplicationInfo> queryPackageManagerForListOfInstalledApps() {
        return getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }

    @NonNull
    private List<String> populateInstalledAppNamesList(List<ApplicationInfo> installedAppsList) {
        List<String> installedApps = new ArrayList<>();
        for(ApplicationInfo applicationInfo : installedAppsList)
            installedApps.add(applicationInfo.loadLabel(getPackageManager()).toString());
        return installedApps;
    }
}
