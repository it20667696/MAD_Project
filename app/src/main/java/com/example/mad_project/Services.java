package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class Services extends AppCompatActivity {

    public Button button;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //To change Action Bar title name
        getSupportActionBar().setTitle("Services");

        //To connect two Activities
        button=(Button) findViewById(R.id.S_btn01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Services.this,Scheduler.class);
                startActivity(intent);
            }
        });

        //To connect two Activities
        button=(Button) findViewById(R.id.S_btn02);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Services.this,PatientDetails.class);
                startActivity(intent);
            }
        });

    }
}