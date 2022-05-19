package com.example.madp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainpage extends AppCompatActivity implements View.OnClickListener {


    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);



        card1 = (CardView) findViewById(R.id.report5);


        card1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.report5:
                i = new Intent(this, HomeActivity.class);
                startActivity(i);
                break;

        }

    }
}