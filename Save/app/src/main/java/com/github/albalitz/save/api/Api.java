package com.github.albalitz.save.api;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.github.albalitz.save.SaveApplication;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by albalitz on 3/24/17.
 */
public class Api {

    private SharedPreferences prefs;
    private Activity callingActivity;

    public Api(Activity callingActivity) {
        this.prefs = SaveApplication.getSharedPreferences();
        this.callingActivity = callingActivity;
    }

    public void updateSavedLinks() {
        String url = this.prefs.getString("pref_key_api_url", null);
        if (url == null) {
            Log.e(this.toString(), "No URL set in the preferences!");
            return;
        }

        JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // todo: use this.callingActivity to update the displayed list
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                // todo
            }
        };
        Request.get(url,
                prefs.getString("pref_key_api_username", null),
                prefs.getString("pref_key_api_password", null),
                null,  // request params
                jsonHttpResponseHandler);
    }
}
