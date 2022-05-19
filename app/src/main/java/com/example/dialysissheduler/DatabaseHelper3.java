package com.example.dialysissheduler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper3 extends SQLiteOpenHelper {

    private static final String DBNAME = "measure";
    private static final String TABLE = "intakes";
    private static final int VER = 1;

    public DatabaseHelper3(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE + "(id integer primary key, Time text, waterLevel text, urineLevel text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists " + TABLE + "";
        db.execSQL(query);
        onCreate(db);
    }


}
