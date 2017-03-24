package com.github.albalitz.save.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.github.albalitz.save.R;

/**
 * Created by albalitz on 3/24/17.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}
