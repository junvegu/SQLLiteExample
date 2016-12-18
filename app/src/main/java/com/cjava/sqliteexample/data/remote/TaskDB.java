package com.cjava.sqliteexample.data.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class TaskDB {

    public static final String TABLE_NAME = "task";
    public static final String TASK_ID = "id";
    public static final String TASK_DETAIL = "detail";
    public static final String TASK_STATUS = "task";

    public static final String CREATE_TABLE = " create table if not exists " + TABLE_NAME
            + " (" + TASK_ID + " integer primary key autoincrement,  "
            + TASK_DETAIL + " text not null, "
            + TASK_STATUS + " text not null default '0' );";


    private DBHelper dbHelper;

    public TaskDB(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public Cursor getTask() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY id DESC", null);
    }

    public void inserTask(String detail, String status){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TASK_DETAIL,detail);
        contentValues.put(TASK_STATUS,status);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

}
