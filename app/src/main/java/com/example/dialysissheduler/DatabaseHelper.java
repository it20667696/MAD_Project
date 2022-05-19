package com.example.dialysissheduler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyUsers";
    public static final String CONTACTS_TABLE_NAME = "cDoctor";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+ CONTACTS_TABLE_NAME +"(id integer primary key, patient_id text,message text)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(db);
    }
    public boolean insert(String s, String s1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("patient_id", s);
        contentValues.put("message", s1);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }


}
