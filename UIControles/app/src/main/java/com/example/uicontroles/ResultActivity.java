package com.example.uicontroles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public static TextView txtfullName,txtphoneNumber,txtcurrentYear,txtselectedCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtfullName=(TextView) findViewById(R.id.txtfullname);
        txtphoneNumber=(TextView) findViewById(R.id.txtphonenumber);
        txtcurrentYear=(TextView) findViewById(R.id.txtcurrentyear);
        txtselectedCourses=(TextView) findViewById(R.id.txtseletctedcourses);

        Intent intent = getIntent();



        txtfullName.setText((String)intent.getSerializableExtra("fullName"));
        txtphoneNumber.setText((String)intent.getSerializableExtra("phoneNumber"));
        txtcurrentYear.setText((String)intent.getSerializableExtra("currentYear"));
        txtselectedCourses.setText((String)intent.getSerializableExtra("selectedCourses"));

    }
}