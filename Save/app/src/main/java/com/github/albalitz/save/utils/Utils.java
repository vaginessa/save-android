package com.github.albalitz.save.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.github.albalitz.save.activities.SnackbarActivity;

/**
 * Created by albalitz on 3/24/17.
 */
public class Utils {
    public static void showSnackbar(SnackbarActivity callingActivity, String text) {
        View viewFromActivity = callingActivity.viewFromActivity();
        Snackbar.make(viewFromActivity, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void openInExternalBrowser(Context context, String url) {
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}
