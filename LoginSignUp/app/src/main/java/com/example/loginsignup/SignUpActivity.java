package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private static EditText Fname;
    private static EditText Lname;
    private static EditText Cont;
    private static EditText Uname;
    private static EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void openLoginPage(View view){
        Intent i = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(i);
    }
    public void signUp(View view){
        Fname=(EditText) findViewById(R.id.edt_FirstName);
        Lname=(EditText) findViewById(R.id.edt_LastName);
        Cont=(EditText) findViewById(R.id.edt_Contact);
        Uname=(EditText) findViewById(R.id.edt_UserName);
        Pass=(EditText) findViewById(R.id.edt_Password);

        User user=new User();
        user.firstName = Fname.getText().toString();
        user.lasttName = Lname.getText().toString();
        user.contact = Cont.getText().toString();
        user.userName = Uname.getText().toString();
        user.password = Pass.getText().toString();



        DbManager db = new DbManager(this);


        //1. check if username already exits

        ArrayList<HashMap<String, String>> userList = db.GetUserByUserName(user.userName);
        if(userList.isEmpty()){//if list is empty then add that user in database
            db.insertUser(user);
            Toast.makeText(getApplicationContext(), "User added successfully!!!",Toast.LENGTH_SHORT).show();
        }else{//else show an alert message to the user
            Toast.makeText(getApplicationContext(), "Username alread exists!!!",Toast.LENGTH_SHORT).show();
        }

    }
}