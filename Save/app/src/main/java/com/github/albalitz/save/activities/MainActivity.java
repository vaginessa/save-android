package com.github.albalitz.save.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.albalitz.save.R;
import com.github.albalitz.save.api.Api;
import com.github.albalitz.save.api.Link;
import com.github.albalitz.save.fragments.LinkActionsDialogFragment;
import com.github.albalitz.save.utils.ActivityUtils;
import com.github.albalitz.save.utils.LinkAdapter;
import com.github.albalitz.save.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements SavedLinksListActivity, LinkActionsDialogFragment.LinkActionListener, SnackbarActivity{

    private Context context;

    private ListView listViewSavedLinks;
    private LinkAdapter adapter;
    private ArrayList<Link> savedLinks;
    private Link selectedLink;

    private Api api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.context = this;

        // assign content
        listViewSavedLinks = (ListView) findViewById(R.id.listViewSavedLinks);

        // prepare stuff
        api = new Api(this);
        prepareListViewListeners();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showSnackbar(MainActivity.this, "TODO: SAVE STUFF");
            }
        });

        // do actual stuff
        api.updateSavedLinks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                ActivityUtils.openSettings(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onSavedLinksUpdate(ArrayList<Link> savedLinks) {
        this.savedLinks = savedLinks;
        adapter = new LinkAdapter(this, savedLinks);
        this.listViewSavedLinks.setAdapter(adapter);
    }


    private void prepareListViewListeners() {
        listViewSavedLinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Link clickedLink = savedLinks.get(position);
                Utils.showSnackbar(MainActivity.this, "Opening link...");
                Utils.openInExternalBrowser(context, clickedLink.url());
            }
        });

        listViewSavedLinks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedLink = savedLinks.get(position);
                LinkActionsDialogFragment linkActionsDialogFragment = new LinkActionsDialogFragment();
                linkActionsDialogFragment.show(getFragmentManager(), "actions");
                return true;
            }
        });
    }

    /*
     * Implement link dialog actions
     */
    @Override
    public void onSelectLinkOpen(DialogFragment dialog) {
        if (selectedLink == null) {
            return;
        }

        Utils.openInExternalBrowser(context, selectedLink.url());
    }

    @Override
    public void onSelectLinkDelete(DialogFragment dialog) {
        if (selectedLink == null) {
            return;
        }

        // todo: delete
    }

    @Override
    public void onDialogDismiss(DialogFragment dialog) {
        selectedLink = null;
    }

    /*
     * Implement SnackbarActivity
     */
    @Override
    public View viewFromActivity() {
        return findViewById(R.id.listViewSavedLinks);
    }
}
