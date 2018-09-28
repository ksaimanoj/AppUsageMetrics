package com.jonam.appusagemetrics;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setText("Manoj");
        textView2.setText("Kadiyala");

        String packageName = "";
        String timeUsed = "";

        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        startActivity(intent);

        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,
                System.currentTimeMillis() - 1*24*60*60*1000,
                System.currentTimeMillis());

        Log.d("Manoj", "usageStatsList.size(): " + usageStatsList.size());

        for(UsageStats usageStat : usageStatsList)
        {
            packageName += usageStat.getPackageName() + formatTIme(usageStat.getTotalTimeInForeground()) + "\n";
            timeUsed += usageStat.getTotalTimeInForeground() + "\n";

            Log.d("Manoj1", "packageName: " + packageName);
            Log.d("Manoj2", "timeUsed: " + timeUsed);
        }

        textView1.setText(packageName);
        textView2.setText(timeUsed);
    }

    private String formatTIme(long totalTimeInForeground) {
        return String.format(" - %ds", totalTimeInForeground/1000);
    }
}
