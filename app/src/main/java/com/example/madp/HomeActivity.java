package com.example.madp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    CardView card1, card2, card3, card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                i = new Intent(this, Dashboard.class);
                startActivity(i);
                break;

            case R.id.report2:
                i = new Intent(this,Feedback.class);
                startActivity(i);
                break;

            case R.id.report3:
                i = new Intent(this,Register.class);
                startActivity(i);
                break;


        }

    }
}