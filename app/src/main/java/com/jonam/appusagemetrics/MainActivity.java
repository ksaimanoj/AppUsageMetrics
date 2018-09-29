package com.jonam.appusagemetrics;

import android.content.pm.*;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.jonam.appusagemetrics.apps.AppDetails;
import com.jonam.appusagemetrics.apps.InstalledAppsManager;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.installedAppsListView);
        List<AppDetails> installedApps = new InstalledAppsManager(getBaseContext()).getAppDetailsList();
        ArrayAdapter adapter = new InstalledAppListAdapater(
                getBaseContext(), android.R.layout.simple_list_item_1 , installedApps);
        listView.setAdapter(adapter);
    }
}
