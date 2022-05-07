package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestStatus extends AppCompatActivity {
    public Button button_view2, back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_status);

        //To change Action Bar title name
        getSupportActionBar().setTitle("Request status");

        button_view2 = findViewById(R.id.button_view2);
        back1 = findViewById(R.id.back1);

        button_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestStatus.this,ViewPatientActivity.class);
                startActivity(intent);
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestStatus.this,Services.class);
                startActivity(intent);
            }
        });

    }
}