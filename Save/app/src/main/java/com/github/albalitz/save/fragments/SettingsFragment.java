package com.github.albalitz.save.fragments;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;

import com.github.albalitz.save.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by albalitz on 3/24/17.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        setValuesAsSummary();
    }

    /**
     * Get the values of specific preferences
     * and set those as the summary,
     * so the values are visible on the preferences screen.
     */
    private void setValuesAsSummary() {
        List<EditTextPreference> editTextPreferences = Arrays.asList(
                (EditTextPreference) findPreference("pref_key_api_url"),
                (EditTextPreference) findPreference("pref_key_api_username")
        );

        for (EditTextPreference pref : editTextPreferences) {
            String setValue = pref.getText();
            if (setValue != null && !setValue.isEmpty()) {
                pref.setSummary(setValue);
            }
        }
    }
}
