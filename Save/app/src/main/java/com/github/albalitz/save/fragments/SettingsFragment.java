package com.github.albalitz.save.fragments;

import android.os.Bundle;
import android.preference.EditTextPreference;
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

        setValuesAsSummary();
    }

    /**
     * Get the values of specific preferences
     * and set those as the summary,
     * so the values are visible on the preferences screen.
     */
    private void setValuesAsSummary() {
        // api url
        EditTextPreference apiUrlEditText = (EditTextPreference) findPreference("pref_key_api_url");
        apiUrlEditText.setSummary(apiUrlEditText.getSummary() + ": " + apiUrlEditText.getText());

        // api user settings
        // not displaying anything special for the password
        EditTextPreference usernameEditText = (EditTextPreference) findPreference("pref_key_api_username");
        apiUrlEditText.setSummary(apiUrlEditText.getSummary() + ": " + apiUrlEditText.getText());
    }
}
