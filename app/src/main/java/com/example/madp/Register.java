package com.example.madp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText email,Password;
    Button Sign_in;
    DBHelper DB;

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        email=findViewById(R.id.email1);
        Password=findViewById(R.id.Password1);
        DB= new DBHelper(this);
        Sign_in=findViewById(R.id.Sign_in);

        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=email.getText().toString();
                String pass=Password.getText().toString();
                
                if(TextUtils.isEmpty(user) ||TextUtils.isEmpty(pass))
                    Toast.makeText(Register.this, "All fields Required", Toast.LENGTH_SHORT).show();
            else{
                Boolean checkuserpass=DB.checkemailPassword(user,pass);
                if(checkuserpass==true){
                    Toast.makeText(Register.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else{

                    Toast.makeText(Register.this, "Login Failed!", Toast.LENGTH_SHORT).show();
               }


                }
            }
        });



//Hello


        setContentView(R.layout.activity_register);

        button=(Button) findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
            });

        }
    }