package com.example.dialysissheduler;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Measure extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);


        ed1 = findViewById(R.id.wlevel);
        ed2 = findViewById(R.id.ulevel);

        b1 = findViewById(R.id.btn_add);
        b2 = findViewById(R.id.btn_view);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),view.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });


    }

    public void insert(){
        try {
            String wlevel = ed1.getText().toString();
            String ulevel = ed2.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("reports", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT, wlevel VARCHAR,ulevel VARCHAR )");


            String sql = "insert into records(wlevel,ulevel)values(?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,wlevel);
            statement.bindString(2,ulevel);
            statement.execute();
            Toast.makeText(this,"Record added",Toast.LENGTH_LONG).show();

            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();

        }
        catch (Exception ex){

            Toast.makeText(this,"record Fail",Toast.LENGTH_LONG).show();
        }





    }
}

