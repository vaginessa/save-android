package com.github.albalitz.save.activities;

import com.github.albalitz.save.api.Link;

import java.util.ArrayList;


public interface SavedLinksListActivity {
    void onSavedLinksUpdate(ArrayList<Link> savedLinks);
}
