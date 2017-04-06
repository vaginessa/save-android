package com.github.albalitz.save.persistence.database;

import android.provider.BaseColumns;

/**
 * Created by albalitz on 4/6/17.
 */
public final class SaveDbContract {

    protected static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + LinkEntry.TABLE_NAME + " (" + LinkEntry._ID + " INTEGER PRIMARY KEY,"
            + LinkEntry.COLUMN_NAME_URL + " TEXT,"
            + LinkEntry.COLUM_NAME_ANNOTATION + " TEXT)";
    protected static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + LinkEntry.TABLE_NAME;

    /**
     * prevent instantiating this.
     */
    private SaveDbContract() {}

    /**
     * Inner class defining table contents
     */
    public static class LinkEntry implements BaseColumns {
        public static final String TABLE_NAME = "links";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUM_NAME_ANNOTATION = "annotation";
    }
}
