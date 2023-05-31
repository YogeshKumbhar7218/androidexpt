package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private static EditText Fname,Lname,Cont,Uname,Pass;
    private static TextView Fname_Err,Lname_Err,Cont_Err,Uname_Err,Pass_Err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void openLoginPage(View view){
        Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(i);
    }
    public void signUp(View view){
        Fname=(EditText) findViewById(R.id.edt_FirstName);
        Lname=(EditText) findViewById(R.id.edt_LastName);
        Cont=(EditText) findViewById(R.id.edt_Contact);
        Uname=(EditText) findViewById(R.id.edt_UserName);
        Pass=(EditText) findViewById(R.id.edt_Password);

        String firstName = Fname.getText().toString();
        String lasttName = Lname.getText().toString();
        String contact = Cont.getText().toString();
        String userName = Uname.getText().toString();
        String password = Pass.getText().toString();


        Fname_Err=(TextView) findViewById(R.id.txt_fnameError);
        Lname_Err=(TextView) findViewById(R.id.txt_lnameError);
        Cont_Err=(TextView) findViewById(R.id.txt_contactError);
        Uname_Err=(TextView) findViewById(R.id.txt_unameError);
        Pass_Err=(TextView) findViewById(R.id.txt_passwordError);

        Fname_Err.setVisibility(View.INVISIBLE);
        Lname_Err.setVisibility(View.INVISIBLE);
        Cont_Err.setVisibility(View.INVISIBLE);
        Uname_Err.setVisibility(View.INVISIBLE);
        Pass_Err.setVisibility(View.INVISIBLE);

        boolean validity = true;
        //Validate

        if (!Pattern.matches("^[a-zA-Z]{1,20}$",firstName)) {
            validity=false;
            Fname_Err.setVisibility(View.VISIBLE);
        }

        if (!Pattern.matches("^[a-zA-Z]{1,20}$",lasttName)) {
            validity=false;
            Lname_Err.setVisibility(View.VISIBLE);
        }

        if (!Pattern.matches("^[0-9]{10}$",contact)) {
            validity=false;
            Cont_Err.setVisibility(View.VISIBLE);
        }


        if (!Pattern.matches("^[a-zA-Z0-9]{1,30}$",userName)) {
            validity=false;
            Uname_Err.setVisibility(View.VISIBLE);
        }
        //passWord
        if (password.isEmpty()) {
            validity=false;
            Pass_Err.setVisibility(View.VISIBLE);
        }


        if(validity){
            DbHelper db = new DbHelper(this);
            //1. check if username already exits
            if(!db.checkusername(userName)){
                db.insertUser(firstName, lasttName, contact, userName, password);
                Toast.makeText(getApplicationContext(), "User added successfully!!!",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Username alread exists!!!",Toast.LENGTH_SHORT).show();
            }

        }

    }
}