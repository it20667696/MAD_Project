package com.example.dialysissheduler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class monthly_report extends AppCompatActivity {

    Button btn_add1;
    EditText patientId, cLevel,gfr,urea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_report);

        final DatabaseHelper2 helper = new DatabaseHelper2(this);
        patientId = findViewById(R.id.patientId);
        cLevel = findViewById(R.id.cLevel);
        gfr = findViewById(R.id.gfr);
        urea = findViewById(R.id.urea);

        findViewById(R.id.btn_add1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!patientId.getText().toString().isEmpty() && !cLevel.getText().toString().isEmpty() && !gfr.getText().toString().isEmpty() && !urea.getText().toString().isEmpty()) {
                    if (helper.insert(patientId.getText().toString(), cLevel.getText().toString(), gfr.getText().toString(), urea.getText().toString())) {
                        Toast.makeText(monthly_report.this, "Inserted", Toast.LENGTH_LONG).show();

                        patientId.setText("");
                        cLevel.setText("");
                        gfr.setText("");
                        urea.setText("");
                        patientId.requestFocus();
                    } else {
                        Toast.makeText(monthly_report.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                    }
                } else {
                    patientId.setError("Enter patient id");
                    cLevel.setError("Enter creatine level");
                    gfr.setError("Enter gfr");
                    urea.setError("Enter urea level");
                }
            }
        });

    }
}