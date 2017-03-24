package com.github.albalitz.save.fragments;

import android.app.Activity;
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
    /**
     * The Activity using this dialog must implement this interface
     * to be able to implement according actions.
     */
    public interface LinkActionListener {
        void onSelectLinkOpen(DialogFragment dialog);
        void onSelectLinkDelete(DialogFragment dialog);
        void onDialogDismiss(DialogFragment dialog);
    }

    LinkActionListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_link_actions_title)
                .setItems(R.array.link_actions_keys, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                listener.onSelectLinkOpen(LinkActionsDialogFragment.this);
                                break;
                            case 1:
                                listener.onSelectLinkDelete(LinkActionsDialogFragment.this);
                                break;
                        }
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (LinkActionListener) activity;
        } catch (ClassCastException cce) {
            throw new ClassCastException(activity.toString() + " must implement LinkActionListener!");
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        listener.onDialogDismiss(this);
    }
}
