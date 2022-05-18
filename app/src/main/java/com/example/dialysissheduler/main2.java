package com.example.dialysissheduler;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;

public class main2 extends AppCompatActivity {
    DatabaseHelper3 dBmain;
    SQLiteDatabase sqLiteDatabase;
    String[] Time, waterLevel,urineLevel;
    int[] id;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dBmain = new DatabaseHelper3(this);
        findid();
        displaydata();
    }

    private void displaydata() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from intakes", null);
        if (cursor.getCount() > 0) {
            id = new int[cursor.getCount()];
            Time = new String[cursor.getCount()];
            waterLevel = new String[cursor.getCount()];
            urineLevel = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                id[i] = cursor.getInt(0);
                Time[i] = cursor.getString(1);
                waterLevel[i] = cursor.getString(2);
                urineLevel[i] = cursor.getString(3);
                i++;
            }
            CustAdapter custAdapter = new CustAdapter();
            lv.setAdapter(custAdapter);
        }
    }

    private void findid() {
        lv = (ListView) findViewById(R.id.lv);
    }

    private class CustAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Time.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            TextView txttime, txtwater,txturine;
            ImageButton txt_edit, txt_delete;
            CardView cardview;
            convertView =  LayoutInflater.from(main2.this).inflate(R.layout.singledata, parent, false);
            txttime = convertView.findViewById(R.id.txt_time);
           txtwater = convertView.findViewById(R.id.txt_water);
            txturine = convertView.findViewById(R.id.txt_urine);
            txt_edit = convertView.findViewById(R.id.txt_edit);
            txt_delete = convertView.findViewById(R.id.txt_delete);
            cardview = convertView.findViewById(R.id.cardview);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //background random color
                    Random random = new Random();
                    cardview.setCardBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                    txt_delete.setVisibility(View.VISIBLE);
                    txt_edit.setVisibility(View.VISIBLE);
                    txttime.setVisibility(View.GONE);
                    txtwater.setVisibility(View.GONE);
                    txturine.setVisibility(View.GONE);
                }
            });
            txttime.setText(Time[position]);
           txtwater.setText(waterLevel[position]);
            txturine.setText(urineLevel[position]);
            txt_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", id[position]);
                    bundle.putString("Time", Time[position]);
                    bundle.putString("waterLevel", waterLevel[position]);
                    bundle.putString("urineLevel", urineLevel[position]);
                    Intent intent = new Intent(main2.this, Measure.class);
                    intent.putExtra("studata", bundle);
                    startActivity(intent);
                }
            });
            txt_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sqLiteDatabase = dBmain.getReadableDatabase();
                    long recremove = sqLiteDatabase.delete("intakes", "id=" + id[position], null);
                    if (recremove != -1) {
                        Toast.makeText(main2.this, "successfully delete", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(main2.this, Measure.class));
                        displaydata();
                    }
                }
            });
            return convertView;
        }
    }


}