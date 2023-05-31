package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

import kotlin.text.Regex;

public class MainActivity extends AppCompatActivity {

    Button button_back, button_Add, button_Sub, button_Div, button_Mul, button_dot, button_C, button_Equal;
    TextView txt_result;
    float mValueOne, mValueTwo;
    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_dot = (Button) findViewById(R.id.button_dot);
        button_Add = (Button) findViewById(R.id.button_add);
        button_Sub = (Button) findViewById(R.id.button_sub);
        button_Mul = (Button) findViewById(R.id.button_mul);
        button_Div = (Button) findViewById(R.id.button_div);
        button_C = (Button) findViewById(R.id.button_C);
        button_Equal = (Button) findViewById(R.id.button_eql);
        txt_result = (TextView) findViewById(R.id.txt_result);
        button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt_result.getText().toString();
                if(!str.isEmpty()){
                    str = str.substring(0,str.length()-1);
                    txt_result.setText( str );
                }

            }
        });
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_result == null) {
                    txt_result.setText("");
                } else {
                    mValueOne = Float.parseFloat(txt_result.getText() + "");
                    crunchifyAddition = true;
                    txt_result.setText(null);
                }
            }
        });
        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(txt_result.getText() + "");
                mSubtract = true;
                txt_result.setText(null);
            }
        });
        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(txt_result.getText() + "");
                crunchifyMultiplication = true;
                txt_result.setText(null);
            }
        });
        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(txt_result.getText() + "");
                crunchifyDivision = true;
                txt_result.setText(null);
            }
        });
        button_Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(txt_result.getText() + "");
                if (crunchifyAddition == true) {
                    txt_result.setText(mValueOne + mValueTwo + "");
                    crunchifyAddition = false;
                }
                if (mSubtract == true) {
                    txt_result.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }
                if (crunchifyMultiplication == true) {
                    txt_result.setText(mValueOne * mValueTwo + "");
                    crunchifyMultiplication = false;
                }
                if (crunchifyDivision == true) {
                    txt_result.setText(mValueOne / mValueTwo + "");
                    crunchifyDivision = false;
                }
            }
        });
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt_result.getText().toString();
                if(Pattern.matches("[.]",str)){
                    txt_result.setText(txt_result.getText() + ".");
                }

            }
        });


    }
    public void numberClick(View view){
        switch(view.getId()){
            case R.id.button_one:
                txt_result.setText(txt_result.getText() + "1");
                break;
            case R.id.button_two:
                txt_result.setText(txt_result.getText() + "2");
                break;
            case R.id.button_three:
                txt_result.setText(txt_result.getText() + "3");
                break;
            case R.id.button_four:
                txt_result.setText(txt_result.getText() + "4");
                break;
            case R.id.button_five:
                txt_result.setText(txt_result.getText() + "5");
                break;
            case R.id.button_six:
                txt_result.setText(txt_result.getText() + "6");
                break;
            case R.id.button_seven:
                txt_result.setText(txt_result.getText() + "7");
                break;
            case R.id.button_eight:
                txt_result.setText(txt_result.getText() + "8");
                break;
            case R.id.button_nine:
                txt_result.setText(txt_result.getText() + "9");
                break;
            case R.id.button_zero:
                txt_result.setText(txt_result.getText() + "0");
                break;
        }
    }
}