package com.github.albalitz.save.persistence;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * Ensuring the classes used for accessing one of the persistence types (API or local DB),
 * use the same methods.
 *
 * Created by albalitz on 4/6/17.
 */
public interface SavePersistenceOption {
    void updateSavedLinks();
    void saveLink(Link link) throws JSONException, UnsupportedEncodingException;
    void deleteLink(Link link);
    void registerUser(final String username, final String password) throws JSONException, UnsupportedEncodingException;
}
