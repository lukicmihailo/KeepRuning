package com.nightwalker.keeprunning.backend.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Westi on 7/19/2016.
 */
public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DatabaseManager(Context context){
        super();
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    


}
