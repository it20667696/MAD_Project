package com.example.madp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBHelper( Context context) {
        super(context, "login.db",  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table users(email TEXT primary key , Password TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String email, String Password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email",email);
        values.put("password",Password);

        long result=db.insert("users",null,values);
        if (result==-1)return false;
        else
            return true;
    }

    public Boolean checkemail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from users where email=?", new String[] {email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailPassword(String email,String Password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from users where  email=? and Password=?", new String[] {email,Password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

