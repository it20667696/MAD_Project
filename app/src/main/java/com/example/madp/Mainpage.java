package com.example.madp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainpage extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        dbHelper = new DBHelper(this);
        card1 = (CardView) findViewById(R.id.report1);
        //card2 = (CardView) findViewById(R.id.report2);
        //card3 = (CardView) findViewById(R.id.report3);
        //card4 = (CardView) findViewById(R.id.report4);

        card1.setOnClickListener(this);
        // card2.setOnClickListener(this);
        //card3.setOnClickListener(this);
        //card4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.report1:
                i = new Intent(this, HomeActivity.class);
                startActivity(i);
                break;
/*
            case R.id.report2:
                i = new Intent(this,Measure.class);
                startActivity(i);
                break;

            case R.id.report3:
                i = new Intent(this,main2.class);
                startActivity(i);
                break;

            case R.id.report4:
                i = new Intent(this,contact_doctor.class);
                startActivity(i);
                break;

*/
        }

    }
}