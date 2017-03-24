package com.github.albalitz.save.api;

import android.content.SharedPreferences;
import android.util.Log;

import com.github.albalitz.save.SaveApplication;
import com.github.albalitz.save.activities.SavedLinksListActivity;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by albalitz on 3/24/17.
 */
public class Api {

    private SharedPreferences prefs;
    private SavedLinksListActivity callingActivity;

    public Api(SavedLinksListActivity callingActivity) {
        this.prefs = SaveApplication.getSharedPreferences();
        this.callingActivity = callingActivity;
    }

    public void updateSavedLinks() {
        String url = this.prefs.getString("pref_key_api_url", null);
        if (url == null) {
            Log.e(this.toString(), "No URL set in the preferences!");
            return;
        } else {
            url += "/links";
        }

        JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("api", "Got " + response.length() + " links from the API: " + response);
                ArrayList<Link> savedLinks = new ArrayList<>();

                for (int i = 0; i < response.length(); i++) {
                    JSONObject linkJson = new JSONObject();

                    try {
                        linkJson = response.getJSONObject(i);
                    } catch (JSONException e) {
                        Log.e("api", e.toString());
                    }

                    if (linkJson != null) {
                        Link link = null;
                        try {
                            link = new Link(linkJson);
                        } catch (JSONException e) {
                            Log.e("api", "JSONException while trying to create Link from JSON: " + e.toString());
                        }
                        savedLinks.add(link);
                    }
                }

                callingActivity.onSavedLinksUpdate(savedLinks);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                // todo
            }
        };

        Log.i("api", "Getting saved list from API: " + url + " ...");
        Request.get(url,
                prefs.getString("pref_key_api_username", null),
                prefs.getString("pref_key_api_password", null),
                null,  // request params
                jsonHttpResponseHandler);
    }
}
