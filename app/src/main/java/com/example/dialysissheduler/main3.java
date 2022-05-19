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

public class main3 extends AppCompatActivity {

    DatabaseHelper4 dBmain;
    SQLiteDatabase sqLiteDatabase;
    String[] patientId, cLevel,gfr,urea;
    int[] id;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dBmain = new DatabaseHelper4(this);
        findid();
        displaydata();
    }

    private void displaydata() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from reports", null);
        if (cursor.getCount() > 0) {
            id = new int[cursor.getCount()];
            patientId = new String[cursor.getCount()];
            cLevel = new String[cursor.getCount()];
            gfr = new String[cursor.getCount()];
            urea = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                id[i] = cursor.getInt(0);
                patientId[i] = cursor.getString(1);
                cLevel[i] = cursor.getString(2);
                gfr[i] = cursor.getString(3);
                urea[i] = cursor.getString(3);
                i++;
            }
            CustAdapter custAdapter = new main3.CustAdapter();
            lv.setAdapter(custAdapter);
        }
    }

    private void findid() {
        lv = (ListView) findViewById(R.id.lv);
    }

    private class CustAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return patientId.length;
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
            TextView txtpatientId, txtcLevel,txtgfr,txturea;
            ImageButton txt_edit2, txt_delete2;
            CardView cardview;
            convertView =  LayoutInflater.from(main3.this).inflate(R.layout.singledata2, parent, false);
            txtpatientId = convertView.findViewById(R.id.txt_patientId);
            txtcLevel = convertView.findViewById(R.id.txt_cLevel);
            txtgfr = convertView.findViewById(R.id.txt_gfr);
            txturea = convertView.findViewById(R.id.txt_urea);
            txt_edit2 = convertView.findViewById(R.id.txt_edit2);
            txt_delete2 = convertView.findViewById(R.id.txt_delete2);
            cardview = convertView.findViewById(R.id.cardview);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //background random color
                    Random random = new Random();
                    cardview.setCardBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                    txt_delete2.setVisibility(View.VISIBLE);
                    txt_edit2.setVisibility(View.VISIBLE);
                    txtpatientId.setVisibility(View.GONE);
                    txtcLevel.setVisibility(View.GONE);
                    txtgfr.setVisibility(View.GONE);
                    txturea.setVisibility(View.GONE);
                }
            });
            txtpatientId.setText(patientId[position]);
            txtcLevel.setText(cLevel[position]);
            txtgfr.setText(gfr[position]);
            txturea.setText(urea[position]);
            txt_edit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", id[position]);
                    bundle.putString("patientId", patientId[position]);
                    bundle.putString("cLevel", cLevel[position]);
                    bundle.putString("gfr", gfr[position]);
                    bundle.putString("urea", urea[position]);
                    Intent intent = new Intent(main3.this, monthly_report.class);
                    intent.putExtra("studata", bundle);
                    startActivity(intent);
                }
            });
            txt_delete2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sqLiteDatabase = dBmain.getReadableDatabase();
                    long recremove = sqLiteDatabase.delete("reports", "id=" + id[position], null);
                    if (recremove != -1) {
                        Toast.makeText(main3.this, "successfully delete", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(main3.this, monthly_report.class));
                        displaydata();
                    }
                }
            });
            return convertView;
        }

    }
}