package com.github.albalitz.save.api;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Wrapper class for HTTP requests.
 */
public class Request {
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, String username, String password, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setBasicAuth(username, password);
        client.get(url, params, responseHandler);
    }

    public static void post(String url, String username, String password, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setBasicAuth(username, password);
        client.post(url, params, responseHandler);
    }

    public static void delete(String url, String username, String password, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setBasicAuth(username, password);
        client.delete(url, params, responseHandler);
    }
}
