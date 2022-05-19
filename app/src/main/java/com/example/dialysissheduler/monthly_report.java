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



public class monthly_report extends AppCompatActivity {


    DatabaseHelper4 dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText patientId, cLevel,gfr,urea;
    Button btn_submit2, btn_display2, btn_edit2;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_report);
        dBmain = new DatabaseHelper4(this);
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
            patientId.setText(bundle.getString("patientId"));
            cLevel.setText(bundle.getString("cLevel"));
            gfr.setText(bundle.getString("gfr"));
            urea.setText(bundle.getString("urea"));

            btn_edit2.setVisibility(View.VISIBLE);
            btn_submit2.setVisibility(View.GONE);
        }
    }

    private void cleardata() {
        patientId.setText("");
        cLevel.setText("");
        urea.setText("");
        gfr.setText("");
    }

    private void insertData() {
        btn_submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("patientId", patientId.getText().toString().trim());
                contentValues.put("cLevel", cLevel.getText().toString().trim());
                contentValues.put("gfr", gfr.getText().toString().trim());
                contentValues.put("urea", urea.getText().toString().trim());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recid = sqLiteDatabase.insert("reports", null, contentValues);
                if (recid != null) {
                    Toast.makeText(monthly_report.this, "successfully insert", Toast.LENGTH_SHORT).show();
                    cleardata();
                } else {
                    Toast.makeText(monthly_report.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_display2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(monthly_report.this, main3.class);
                startActivity(intent);
            }
        });
        btn_edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("patientId", patientId.getText().toString().trim());
                contentValues.put("cLevel", cLevel.getText().toString().trim());
                contentValues.put("gfr", gfr.getText().toString().trim());
                contentValues.put("urea", urea.getText().toString().trim());

                sqLiteDatabase = dBmain.getWritableDatabase();
                long recid = sqLiteDatabase.update("reports", contentValues, "id=" + id, null);
                if (recid != -1) {
                    Toast.makeText(monthly_report.this, "Update successfully", Toast.LENGTH_SHORT).show();
                    btn_submit2.setVisibility(View.VISIBLE);
                    btn_edit2.setVisibility(View.GONE);
                    cleardata();
                } else {
                    Toast.makeText(monthly_report.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findid() {
        patientId = (EditText) findViewById(R.id.patientId);
        cLevel = (EditText) findViewById(R.id.cLevel);
        gfr = (EditText) findViewById(R.id.gfr);
        urea = (EditText) findViewById(R.id.urea );
        btn_submit2 = (Button) findViewById(R.id.btn_submit2);
        btn_display2 = (Button) findViewById(R.id.btn_display2);
        btn_edit2 = (Button) findViewById(R.id.btn_edit2);
    }
}