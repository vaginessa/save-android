package com.github.albalitz.save.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.albalitz.save.R;
import com.github.albalitz.save.persistence.Link;

import java.util.ArrayList;

/**
 * Adapter for populating a ListView of Links.
 * See https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 */
public class LinkAdapter extends ArrayAdapter<Link> {

    public LinkAdapter(Context context, ArrayList<Link> savedLinks) {
        super(context, 0, savedLinks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Link link = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.saved_links_list_item, parent, false);
        }

        TextView textViewUrl = (TextView) convertView.findViewById(R.id.savedLinkUrl);
        TextView textViewAnnotation = (TextView) convertView.findViewById(R.id.savedLinkAnnotation);

        textViewUrl.setText(link.url());
        if (link.annotation().isEmpty()) {
            Log.d(this.toString(), "Hiding empty annotation for link: " + link.url() + ".");
            textViewAnnotation.setVisibility(View.GONE);
        } else {
            textViewAnnotation.setText(link.annotation());
        }

        return convertView;
    }
}
