package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThreadClass t1=new ThreadClass("Thread 1");
        ThreadClass t2=new ThreadClass("Thread 2");

        t1.start();
        t2.start();
    }
}