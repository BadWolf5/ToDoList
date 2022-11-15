package com.example.todolistproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Tasks.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = " tasks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LIST = "list";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_COMPLETED = "completed";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT , " +
                        COLUMN_LIST + " TEXT, " +
                        COLUMN_DATE + " TEXT, " +
                        COLUMN_COMPLETED + " TEXT) ;";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTask(String name, String list, String date, Boolean completed) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_LIST, list);
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_COMPLETED, String.valueOf(completed));


        // Check if it was successful
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
        }


    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
