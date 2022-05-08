package com.example.dialysissheduler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class view extends AppCompatActivity {


    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        SQLiteDatabase db = openOrCreateDatabase("reports",Context.MODE_PRIVATE,null);

        lst1 = findViewById(R.id.lst1);
        final Cursor c = db.rawQuery("select * from records",null);
        int id = c.getColumnIndex("id");
        int wlevel = c.getColumnIndex("wlevel");
        int ulevel = c.getColumnIndex("ulevel");

        titles.clear();


        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final  ArrayList<student> stud = new ArrayList<student>();


        if(c.moveToFirst())
        {
            do{
                student stu = new student();
                stu.id = c.getString(id);
                stu.wlevel = c.getString(wlevel );
                stu.ulevel = c.getString(ulevel);


                stud.add(stu);

                titles.add(c.getString(id) + " \t " + c.getString(wlevel ) + " \t "  + c.getString(ulevel )  );

            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();



        }



    }
}