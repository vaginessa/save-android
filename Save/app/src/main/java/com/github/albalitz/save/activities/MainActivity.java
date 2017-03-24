package com.github.albalitz.save.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ListView;

import com.github.albalitz.save.R;
import com.github.albalitz.save.api.Api;
import com.github.albalitz.save.api.Link;
import com.github.albalitz.save.utils.ActivityUtils;
import com.github.albalitz.save.utils.Utils;
import com.github.albalitz.save.utils.LinkAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements SavedLinksListActivity {

    private ListView listViewSavedLinks;
    private LinkAdapter adapter;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // assign content
        listViewSavedLinks = (ListView) findViewById(R.id.listViewSavedLinks);

        // prepare stuff
        api = new Api(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showSnackbar(view, "TODO: SAVE STUFF");
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
        adapter = new LinkAdapter(this, savedLinks);
        this.listViewSavedLinks.setAdapter(adapter);
    }
}
