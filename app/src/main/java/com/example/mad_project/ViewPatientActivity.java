package com.example.mad_project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewPatientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        //To change Action Bar title name
        getSupportActionBar().setTitle("Patient Details");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<PatientModelClass> patientModelClasses = databaseHelperClass.getEmployeeList();

        if (patientModelClasses.size() > 0){
            PatientAdapterClass patientadapterclass = new PatientAdapterClass(patientModelClasses,ViewPatientActivity.this);
            recyclerView.setAdapter(patientadapterclass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }

    }
}
