package com.example.dialysissheduler;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Measure extends AppCompatActivity {

    DatabaseHelper3 dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText Time, waterLevel,urineLevel;
    Button btn_submit, btn_display, btn_edit;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        dBmain = new DatabaseHelper3(this);
        //create object
        findid();
        insertData();
        cleardata();
        editdata();
    }

    private void editdata() {
        if (getIntent().getBundleExtra("studata") != null) {
            Bundle bundle = getIntent().getBundleExtra("studata");
            id = bundle.getInt("id");
            Time.setText(bundle.getString("Time"));
            waterLevel.setText(bundle.getString("waterLevel"));
            urineLevel.setText(bundle.getString("urineLevel"));

            btn_edit.setVisibility(View.VISIBLE);
            btn_submit.setVisibility(View.GONE);
        }
    }

    private void cleardata() {
        Time.setText("");
        waterLevel.setText("");
        urineLevel.setText("");
    }

    private void insertData() {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("Time", Time.getText().toString().trim());
                contentValues.put("waterLevel", waterLevel.getText().toString().trim());
                contentValues.put("urineLevel", urineLevel.getText().toString().trim());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recid = sqLiteDatabase.insert("intakes", null, contentValues);
                if (recid != null) {
                    Toast.makeText(Measure.this, "successfully insert", Toast.LENGTH_SHORT).show();
                    cleardata();
                } else {
                    Toast.makeText(Measure.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Measure.this, main2.class);
                startActivity(intent);
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("Time", Time.getText().toString().trim());
                contentValues.put("waterLevel", waterLevel.getText().toString().trim());
                contentValues.put("urineLevel", urineLevel.getText().toString().trim());

                sqLiteDatabase = dBmain.getWritableDatabase();
                long recid = sqLiteDatabase.update("intakes", contentValues, "id=" + id, null);
                if (recid != -1) {
                    Toast.makeText(Measure.this, "Update successfully", Toast.LENGTH_SHORT).show();
                    btn_submit.setVisibility(View.VISIBLE);
                    btn_edit.setVisibility(View.GONE);
                    cleardata();
                } else {
                    Toast.makeText(Measure.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findid() {
        Time = (EditText) findViewById(R.id.Time);
        waterLevel = (EditText) findViewById(R.id.waterLevel);
        urineLevel = (EditText) findViewById(R.id.urineLevel);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_display = (Button) findViewById(R.id.btn_display);
        btn_edit = (Button) findViewById(R.id.btn_edit);
    }
}