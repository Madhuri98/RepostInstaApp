package com.repost.insta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.repost.insta.model.database.DatabaseListPOJO;
import com.repost.insta.model.database.DatabasePOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niyati on 2/9/2017.
 */

public class DatabaseAccess {
    private DatabaseManager openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    Context context;


    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseManager(context);
        this.context = context;
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public DatabaseListPOJO getData(String table) {
        DatabaseListPOJO databaseListPOJO= new DatabaseListPOJO();
        DatabasePOJO databasePOJO;
        List<DatabasePOJO> pojos = new ArrayList<>();
        open();
        Cursor cursor = database.rawQuery("SELECT * FROM " + table, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                databasePOJO = new DatabasePOJO();
                databasePOJO.setAuthor(cursor.getString(1));
                databasePOJO.setDescription(cursor.getString(2));
                databasePOJO.setPhoto(cursor.getString(3));
                databasePOJO.setMediaID(cursor.getString(4));
                databasePOJO.setAuthorFullname(cursor.getString(5));
                databasePOJO.setAuthorPhoto(cursor.getString(6));
                databasePOJO.setVideo(cursor.getString(7));
                databasePOJO.setIsVideo(cursor.getString(8));
                databasePOJO.setThumb(cursor.getString(9));
                pojos.add(databasePOJO);
            } while (cursor.moveToNext());
        }
        databaseListPOJO.setDatabasePOJOList(pojos);
        cursor.close();
        close();
        return databaseListPOJO;
    }

    public void insertSingleRecord(String table, ContentValues keyValue) {
        open();
        System.out.println("Dataa inserted......");
        database.insert(table,null,keyValue);
        database.close();
    }

    public void deleteRecords(String table) {
        open();
        String string[] = {table + "Is NOT Null"};
        database.delete(table, null, null);
        database.close();
    }
}

