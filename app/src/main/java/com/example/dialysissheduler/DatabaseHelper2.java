package com.example.dialysissheduler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MonthlyReports";
    public static final String CONTACTS_TABLE_NAME = "reports";
    public DatabaseHelper2(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+ CONTACTS_TABLE_NAME +"(id integer primary key, patientId text, cLevel text, gfr text, urea text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(db);
    }
    public boolean insert(String s, String s1, String s2, String s3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("patientId", s);
        contentValues.put("cLevel", s1);
        contentValues.put("gfr", s2);
        contentValues.put("urea", s3);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }
}
