package com.github.albalitz.save;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.github.albalitz.save.fragments.SettingsFragment;

/**
 * Created by albalitz on 3/24/17.
 */
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(this.toString(), "Creating settingsActivity.");

        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
