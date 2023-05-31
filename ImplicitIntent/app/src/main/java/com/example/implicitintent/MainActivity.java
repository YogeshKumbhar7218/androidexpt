package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openUrl(View view){
    this.txt =(EditText) findViewById(R.id.txtUrl);
    String url= txt.getText().toString();
    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    startActivity(i);

    }
}