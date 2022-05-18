package com.example.dialysissheduler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class contact_doctor extends AppCompatActivity {

    Button submit;
    EditText patient_id, message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_doctor);

        final DatabaseHelper helper = new DatabaseHelper(this);
        patient_id = findViewById(R.id.patient_id);
        message = findViewById(R.id.message);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!patient_id.getText().toString().isEmpty() && !message.getText().toString().isEmpty()) {
                    if (helper.insert(patient_id.getText().toString(), message.getText().toString())) {
                        Toast.makeText(contact_doctor.this, "Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(contact_doctor.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                    }
                } else {
                    patient_id.setError("Enter patient id");
                    message.setError("Enter your message");
                }
            }
        });


    }
}