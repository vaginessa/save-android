package com.github.albalitz.save.utils;

import android.app.Activity;
import android.content.Intent;

import com.github.albalitz.save.activities.SettingsActivity;

/**
 * This class contains static methods for starting global activities
 * that are supposed to be accessible from anywhere within the app.
 */
public class ActivityUtils {

    public static void openSettings(Activity fromActivity) {
        Intent intent = new Intent(fromActivity, SettingsActivity.class);
        fromActivity.startActivity(intent);
    }
}
