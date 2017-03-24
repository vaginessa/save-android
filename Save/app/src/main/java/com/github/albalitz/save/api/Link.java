package com.github.albalitz.save.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Representation of what is saved and returned by the api
 */
public class Link {
    private int id;
    private String url;
    private String annotation;
    private String createdOn;
    private String updatedOn;

    public Link(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.url = json.getString("url");
        this.annotation = json.getString("annotation");
        this.createdOn = json.getString("created_on");
        this.updatedOn = json.getString("updated_on");
    }

    public Link(int id, String url, String annotation, String createdOn, String updatedOn) {
        this.id = id;
        this.url = url;
        this.annotation = annotation;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
}
