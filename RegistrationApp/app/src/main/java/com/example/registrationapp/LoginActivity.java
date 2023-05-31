package com.example.registrationapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static EditText Uname,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openSignUpPage(View view){
        Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(i);
    }
    public void login(View view){
        Uname =(EditText) findViewById(R.id.edt_UserName);
        Pass =(EditText) findViewById(R.id.edt_Password);

        String userName = Uname.getText().toString();
        String password = Pass.getText().toString();

        DbHelper db = new DbHelper(this);


        //1. check if username exits


        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Login Alert")
                .setMessage("Entered Username or Password is wrong !")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this,"Selected Option: OK",Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog  = builder.create();

        if(db.checkusernamepassword(userName,password)){
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this,Home.class);
            startActivity(i);


        }else{
            //Toast.makeText(getApplicationContext(), "Username or Password Error!!!",Toast.LENGTH_SHORT).show();
            dialog.show();
        }
    }
}