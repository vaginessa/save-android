package com.github.albalitz.save.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by albalitz on 3/24/17.
 */
public class Utils {
    public static void showSnackbar(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static void openInExternalBrowser(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}
