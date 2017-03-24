package com.github.albalitz.save.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.github.albalitz.save.R;

/**
 * Created by albalitz on 3/24/17.
 */
public class LinkActionsDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_link_actions_title)
                .setItems(R.array.link_actions_keys, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // todo (which = index)
                    }
                });
        return builder.create();
    }
}
