package com.example.dialysissheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class monthly_report extends AppCompatActivity {

    EditText patient_id,creatine_level,gfr,urea,pottasium,sodium;
    Button btn_add1,btn_view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_report);

        patient_id = findViewById(R.id.patient_id);
        creatine_level = findViewById(R.id.creatine_level);
        gfr = findViewById(R.id.gfr);
        urea = findViewById(R.id.urea);
        pottasium = findViewById(R.id.pottasium);
        sodium = findViewById(R.id.sodium);

        btn_add1 = findViewById(R.id.btn_add1);
        btn_view2 = findViewById(R.id.btn_view2);

//testing
        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringPid = patient_id.getText().toString();
                String stringC_level = creatine_level.getText().toString();
                String stringGfr = gfr .getText().toString();
                String stringUrea = urea.getText().toString();
                String stringPottasium = pottasium.getText().toString();
                String stringSodium = sodium.getText().toString();


                if (stringPid.length() <=0 || stringC_level.length() <=0 || stringGfr.length() <=0|| stringUrea.length() <=0|| stringPottasium.length() <=0|| stringSodium.length() <=0){
                    Toast.makeText(monthly_report.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(monthly_report.this);
                    PatientModelClass patientModelClass = new PatientModelClass(stringPid,stringC_level,stringGfr,stringUrea,stringPottasium,stringSodium);
                    databaseHelperClass.addPatient(patientModelClass);
                    Toast.makeText(monthly_report.this, "Add Employee Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        btn_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(monthly_report.this,ViewEmployeeActivity.class);
                startActivity(intent);
            }
        });
}