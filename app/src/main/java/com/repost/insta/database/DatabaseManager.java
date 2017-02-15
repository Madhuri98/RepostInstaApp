package com.repost.insta.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Niyati on 2/9/2017.
 */

public class DatabaseManager extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "ReShare.sqlite";
    private static final int DATABASE_VERSION = 1;


    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
