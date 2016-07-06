package com.androidcss.chromecustomtabs;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // website to be visited
    static final String SITE_URL = "http://androidcss.com/";

    // Define variables for custom tabs and its builder
    CustomTabsIntent customTabsIntent;
    CustomTabsIntent.Builder intentBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize intentBuilder
        intentBuilder = new CustomTabsIntent.Builder();

        // Set toolbar(tab) color of your chrome browser
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));

        // Define entry and exit animation
        intentBuilder.setExitAnimations(this, R.anim.right_to_left_end, R.anim.left_to_right_end);
        intentBuilder.setStartAnimations(this, R.anim.left_to_right_start, R.anim.right_to_left_start);
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));

        // build it by setting up all
        customTabsIntent = intentBuilder.build();

    }

    // triggers when button clicked
    public void ButtonClicked(View arg0) {

        // go to website defined above
        customTabsIntent.launchUrl(this, Uri.parse(SITE_URL));

    }

}
