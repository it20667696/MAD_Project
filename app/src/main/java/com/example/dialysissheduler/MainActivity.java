package com.example.dialysissheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView card1,card2,card4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = (CardView) findViewById(R.id.report1);
        card2 = (CardView) findViewById(R.id.report2);
        card4 = (CardView) findViewById(R.id.report4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.report1:
                i = new Intent(this,monthly_report.class);
                startActivity(i);
                break;

            case R.id.report2:
                i = new Intent(this,Measure.class);
                startActivity(i);
                break;

            case R.id.report4:
                i = new Intent(this,contact_doctor.class);
                startActivity(i);
                break;
        }

    }
}