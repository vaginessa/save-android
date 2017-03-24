package com.github.albalitz.save.activities;

import android.view.View;

/**
 * Activities using utils.Utils.openSnackbar must implement this.
 */
public interface SnackbarActivity {
    /**
     * Returns a view that's always present in the activity,
     * to allow the snackbar to use this view.
     * @return A view from the activity
     */
    View viewFromActivity();
}
