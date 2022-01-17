package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txt1,txt2;
    Button login;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt1 = (EditText) findViewById(R.id.Lusername);
        txt2 = (EditText) findViewById(R.id.Lpassword);
        login = (Button) findViewById(R.id.Login);
        db = new DbHelper(Login.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = txt1.getText().toString();
                String userpswd = txt2.getText().toString();

                boolean check = db.loginemail(useremail,userpswd);
                if (check == true){
                    Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void gotosignup(View view){
        Intent i = new Intent(Login.this,MainActivity.class);
        startActivity(i);
    }

}