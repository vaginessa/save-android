package com.github.albalitz.save.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.github.albalitz.save.R;
import com.github.albalitz.save.activities.MainActivity;
import com.github.albalitz.save.activities.SnackbarActivity;
import com.github.albalitz.save.api.Api;
import com.github.albalitz.save.api.Link;
import com.github.albalitz.save.utils.Utils;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * Created by albalitz on 3/24/17.
 */
public class SaveLinkDialogFragment extends DialogFragment {

    private Activity listener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_save_link_title)
                .setView(R.layout.dialog_save_link);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String url = ((EditText) getDialog().findViewById(R.id.save_dialog_link_url)).getText().toString();
                String annotation = ((EditText) getDialog().findViewById(R.id.save_dialog_link_annotation)).getText().toString();
                if (url.isEmpty() || url.equals("http://") || url.equals("https://")) {
                    Utils.showToast(listener, "Please enter a URL.");
                    // todo: disable this button while no url is entered!
                    return;
                }
                Link link = new Link(url, annotation);

                Utils.showSnackbar((SnackbarActivity) listener, "Saving link...");
                Api api = ((MainActivity) listener).getApi();
                try {
                    api.saveLink(link);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        return builder.create();
    }
}
