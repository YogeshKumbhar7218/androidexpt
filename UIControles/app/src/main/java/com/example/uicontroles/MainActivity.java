package com.example.uicontroles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public static EditText edtFullName, edtPhoneNumber;
    public static CheckBox chbJava, chbPython,chbAndroid, chbAngular;

    public static RadioButton rbFirstYear,rbSecondYear, rbThirdYear, rbFourthYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFullName = (EditText)findViewById(R.id.edtFullName);
        edtPhoneNumber=(EditText)findViewById(R.id.edtPhoneNumber);

        chbAndroid = (CheckBox)findViewById(R.id.chkAndroid);
        chbAngular = (CheckBox)findViewById(R.id.chkAngular);
        chbJava = (CheckBox)findViewById(R.id.chkJava);
        chbPython = (CheckBox)findViewById(R.id.chkPython);

        rbFirstYear =(RadioButton)findViewById(R.id.rdbFirstYear);
        rbSecondYear=(RadioButton)findViewById(R.id.rdbSecondYear);
        rbThirdYear=(RadioButton)findViewById(R.id.rdbThirdYear);
        rbFourthYear=(RadioButton)findViewById(R.id.rdbFourthYear);



    }
    public void onRadioButtonClicked(View view){

    }
    public void onCheckboxClicked(View view){

    }

    public void submitClick(View view){
        String fullName= "Full Name: "+edtFullName.getText().toString();
        String phoneNumber="Phone Number: "+ edtPhoneNumber.getText().toString();

        String selectedCourses = "Selected Courses: ";
        if(chbAndroid.isChecked()){
            selectedCourses += "\nAndroid";
        }
        if(chbAngular.isChecked()){
            selectedCourses += "\nAngularJS";
        }
        if(chbJava.isChecked()){
            selectedCourses += "\nJava";
        }
        if(chbPython.isChecked()){
            selectedCourses += "\nPython";
        }


        String currentYear = "Selected Year: ";
        currentYear+= (rbFirstYear.isChecked())?"First Year":(rbSecondYear.isChecked())?"Second Year":(rbThirdYear.isChecked())?"Third Year":(rbFourthYear.isChecked())?"Fourth Year":"";


        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("fullName",fullName);
        intent.putExtra("phoneNumber",phoneNumber);
        intent.putExtra("currentYear",currentYear);
        intent.putExtra("selectedCourses",selectedCourses);
        startActivity(intent);
    }

}