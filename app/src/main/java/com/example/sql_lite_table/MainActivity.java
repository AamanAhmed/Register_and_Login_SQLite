package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Rusername,Remail,Rpassword,RCpassword;
    Button Register;
    DbHelper Dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rusername = (EditText) findViewById(R.id.Rusername);
        Remail = (EditText) findViewById(R.id.Lusername);
        Rpassword = (EditText) findViewById(R.id.Lpassword);
        RCpassword = (EditText) findViewById(R.id.RCpassword);
        Register = (Button) findViewById(R.id.Login);
        Dbhelper = new DbHelper(MainActivity.this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rusername = Rusername.getText().toString();
                String remail = Remail.getText().toString();
                String rpassword = Rpassword.getText().toString();
                String rcpassword = RCpassword.getText().toString();
                if (rpassword.equals(rcpassword)) {

                    boolean email = Dbhelper.checkemail(remail);
                    if (email == true) {
                        Toast.makeText(MainActivity.this, "Email Already Exist", Toast.LENGTH_SHORT).show();
                    } else {

                        boolean successfullyinserted = Dbhelper.Insertrecord(rusername, remail, rpassword);
                        if (successfullyinserted == true) {
                            Toast.makeText(MainActivity.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();

                        }

                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void gotosignin(View view){
        Intent i = new Intent(MainActivity.this,Login.class);
        startActivity(i);
    }
}