package com.example.loginsignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static EditText Uname;
    private static EditText Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openSignUpPage(View view){
        Intent i = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);
    }
    public void login(View view){
        Uname =(EditText) findViewById(R.id.edt_UserName);
        Pass =(EditText) findViewById(R.id.edt_Password);
        User user = new User();
        user.userName = Uname.getText().toString();
        user.password = Pass.getText().toString();

        DbManager db = new DbManager(this);


        //1. check if username exits

        ArrayList<HashMap<String, String>> userList = db.GetUserByUserName(user.userName);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login Alert")
                .setMessage("Entered Username or Password is wrong !")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Selected Option: OK",Toast.LENGTH_SHORT).show();
                    }
                });

        //Creating dialog box
        AlertDialog dialog  = builder.create();

        if(userList.isEmpty()){//if list is empty then show Error
            //Toast.makeText(getApplicationContext(), "Username or Password Error!!!",Toast.LENGTH_SHORT).show();
            dialog.show();
        }else{//if usrname exists confirm password
            if(userList.get(0).get("password").equals(user.password)) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,Home.class);
                startActivity(i);
            }else{
                //Toast.makeText(getApplicationContext(), "Username or Password Error!!!",Toast.LENGTH_SHORT).show();
                dialog.show();
            }

        }
    }
}