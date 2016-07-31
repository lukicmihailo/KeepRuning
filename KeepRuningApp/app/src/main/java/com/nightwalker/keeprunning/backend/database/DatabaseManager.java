package com.nightwalker.keeprunning.backend.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nightwalker.keeprunning.backend.database.tables.RunningActivityTable;
import com.nightwalker.keeprunning.backend.model.classes.RunningActivity;
import com.nightwalker.keeprunning.backend.model.enums.RunningActivityEnum;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Westi on 7/19/2016.
 */
public class DatabaseManager {

    private final String LOG_NAME = "DATABASE_MANAGER";

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private SQLiteDatabase database;
    private static DatabaseManager instance;

    public static DatabaseManager getInstance(Context context){
        if(instance == null){
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    public DatabaseManager(Context context){
        super();
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        database = dbHelper.getReadableDatabase();
    }

    public void addRunningActivity(RunningActivity activity){
        if(db == null){
            Log.d(LOG_NAME,"addRunningActivity : Database is null");
        }
        else{
            ContentValues values = new ContentValues();
            values.put(RunningActivityTable.COLUMN_NAME_ACTIVITY_TYPE, activity.getType().getIntValue());
            values.put(RunningActivityTable.COLUMN_NAME_AVERAGE_SPEED, activity.getAverageSpeed());
            values.put(RunningActivityTable.COLUMN_NAME_DATE, activity.getDate().toString());
            values.put(RunningActivityTable.COLUMN_NAME_DISTANCE,activity.getDistance());
            values.put(RunningActivityTable.COLUMN_NAME_PARENT_ID,activity.getParentId());
            values.put(RunningActivityTable.COLUMN_NAME_TIME_ELAPSED, activity.getTimeElapsed());
            db.insert(RunningActivityTable.TABLE_NAME, null, values);
            db.close(); // Closing database connection
        }
    }

    public RunningActivity getActivityById(long id){
        String selectQuery = "SELECT  * FROM " + RunningActivityTable.TABLE_NAME + " WHERE " + RunningActivityTable.COLUMN_NAME_ACTIVITY_ID + "LIKE '"+ id + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        RunningActivity activity = null;
        if (cursor.moveToFirst()) {
            activity = convertCursorIntoActivity(cursor);
        }
        return activity;
    }

    public ArrayList<RunningActivity> getAllActivities(){
        ArrayList<RunningActivity> activities = null;
        String selectQuery = "SELECT  * FROM " + RunningActivityTable.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            activities = new ArrayList<RunningActivity>();
            do {
                activities.add(convertCursorIntoActivity(cursor));
            }while (cursor.moveToNext());
        }
        return activities;
    }



    private ArrayList<RunningActivity> getLapsForActivityId(long id) {
        ArrayList<RunningActivity> laps = null;
        String selectQuery = "SELECT  * FROM " + RunningActivityTable.TABLE_NAME + " WHERE " + RunningActivityTable.COLUMN_NAME_PARENT_ID + "LIKE '"+ id + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            laps = new ArrayList<RunningActivity>();
            do {
                laps.add(convertCursorIntoActivity(cursor));
            }while (cursor.moveToNext());
        }
        return laps;
    }


    private RunningActivity convertCursorIntoActivity(Cursor cursor){
        RunningActivity activity = new RunningActivity();
        activity.setActivityId(cursor.getLong(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_ACTIVITY_ID)));
        activity.setAverageSpeed(cursor.getDouble(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_AVERAGE_SPEED)));
        activity.setDistance(cursor.getInt(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_DISTANCE)));
        activity.setParentId(cursor.getLong(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_PARENT_ID)));
        activity.setTimeElapsed(cursor.getInt(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_TIME_ELAPSED)));
        //Get Date from database
        String dateFromDb = cursor.getString(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_DATE));
        Date date = new Date(dateFromDb);
        activity.setDate(date);
        //Get type from database
        activity.setType(getTypeByIntValue(cursor.getInt(cursor.getColumnIndex(RunningActivityTable.COLUMN_NAME_ACTIVITY_TYPE))));
        // Get child activities
        activity.setLaps(getLapsForActivityId(activity.getActivityId()));
        return activity;
    }

    private RunningActivityEnum getTypeByIntValue(int value){
        switch (value){
            case 0:
                return RunningActivityEnum.SIMPLE_RUNNING;
            case 1:
                return RunningActivityEnum.KEEP_RYTHM;
            case 2:
                return RunningActivityEnum.LONG_DISTANCE;
            case 3:
                return RunningActivityEnum.SHORT_TRACKS;
        }
        return null;
    }



}
