package com.nightwalker.keeprunning.backend.database.tables;

import android.provider.BaseColumns;

/**
 * Created by Westi on 7/18/2016.
 */
public class RunningActivityTable implements BaseColumns {

    public static final String TABLE_NAME = "running_activities";
    public static final String COLUMN_NAME_ACTIVITY_ID = "id";
    public static final String COLUMN_NAME_ACTIVITY_TYPE = "type";
    public static final String COLUMN_NAME_PARENT_ID = "parent_id";
    public static final String COLUMN_NAME_TIME_ELAPSED = "time_elapsed";
    public static final String COLUMN_NAME_DISTANCE = "distance";
    public static final String COLUMN_NAME_AVERAGE_SPEED = "average_speed";
    public static final String COLUMN_NAME_DATE = "date";

    // Create sql command for create and drop

    public static final String CREATE_TABLE =
            "CREATE TABLE " + RunningActivityTable.TABLE_NAME
            + " ( "
            + RunningActivityTable.COLUMN_NAME_ACTIVITY_ID + " INTEGER PRIMARY KEY, "
            + RunningActivityTable.COLUMN_NAME_ACTIVITY_TYPE + " INTEGER NOT NULL ,"
            + RunningActivityTable.COLUMN_NAME_PARENT_ID + " INTEGER , "
            + RunningActivityTable.COLUMN_NAME_TIME_ELAPSED + " INTEGER NOT NULL , "
            + RunningActivityTable.COLUMN_NAME_DISTANCE + " INTEGER NOT NULL , "
            + RunningActivityTable.COLUMN_NAME_AVERAGE_SPEED + " REAL NOT NULL, "
            + RunningActivityTable.COLUMN_NAME_DATE + " TEXT NOT NULL "
            + " ) ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
