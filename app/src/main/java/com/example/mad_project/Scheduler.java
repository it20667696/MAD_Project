package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Scheduler extends AppCompatActivity {

    TextView Sc_txt01,Sc_txt02;
    Button Sc_btn01,Sc_btn02,Sc_btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        //To change Action Bar title name
        getSupportActionBar().setTitle("Dialysis Schedular");

        Sc_txt02=(TextView) findViewById(R.id.Sc_txt02);
        Sc_txt01=(TextView) findViewById(R.id.Sc_txt01);
        Sc_btn02=(Button) findViewById(R.id.Sc_btn02);
        Sc_btn01=(Button) findViewById(R.id.Sc_btn01);
        Sc_btn03=(Button) findViewById(R.id.Sc_btn03);

        Sc_btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
            
        });

        Sc_btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });

        Sc_btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Scheduler.this, "Scheduled Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Scheduler.this,Services.class);
                startActivity(intent);
            }
        });
    }

    private void setDate() {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                String showDate=date+"/"+(month+1)+"/"+year;
                Sc_txt01.setText(showDate);


            }
        },year,month,date);

        datePickerDialog.show();
    }

    private void setTime() {
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR);
        int min=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                String showTime=hour+":"+min;
                Sc_txt02.setText(showTime);
            }
        },hour,min,true);
        timePickerDialog.show();
    }
}