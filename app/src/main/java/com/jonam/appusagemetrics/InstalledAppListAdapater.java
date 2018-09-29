package com.jonam.appusagemetrics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonam.appusagemetrics.installedapps.InstalledAppDetails;

import java.util.List;

public class InstalledAppListAdapater extends ArrayAdapter {

    List<InstalledAppDetails> appDetails;
    List appLogos;

    public InstalledAppListAdapater(Context context, int resource, List<InstalledAppDetails> appDetails) {
        super(context, resource, appDetails);

        this.appDetails = appDetails;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View appDisplay = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.installed_app_display, null);
        ImageView appLogo = appDisplay.findViewById(R.id.appLogoImageView);
        TextView appName = appDisplay.findViewById(R.id.appNameTextView);

        appLogo.setImageDrawable(appDetails.get(position).getAppLogo());
        appName.setText(appDetails.get(position).getAppName());

        return appDisplay;
    }
}
