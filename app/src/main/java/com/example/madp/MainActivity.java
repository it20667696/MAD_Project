package com.example.madp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity<button> extends AppCompatActivity {
    EditText email,Password,ConfirmPassword;
    Button register,Sign_in;
    DBHelper DB;

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email1);
        Password=findViewById(R.id.Password1);
        register=findViewById(R.id.register);
        Sign_in=findViewById(R.id.Sign_in);
        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=email.getText().toString();
                String pass=Password.getText().toString();
                String Cpass=ConfirmPassword.getText().toString();


                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)|| TextUtils.isEmpty(Cpass))
                    Toast.makeText(MainActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(Cpass)){
                        boolean checkuser = DB.checkemail(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true) {
                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                                Toast.makeText(MainActivity.this,"User already Exists",Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(MainActivity.this, "Passwords Do not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });


        Sign_in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(),Register.class);
                    startActivity(intent);

                }
            });

        button=(Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

    }
}