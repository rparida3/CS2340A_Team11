package com.example.cs2340a_team11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Initial_Config_Screen extends AppCompatActivity { ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config_screen);


        TextView nameBox = (TextView) findViewById(R.id.nameBox);

        nameBox.setText("What is your name?");


        Button medium = new Button(getApplicationContext());
        Button hard = new Button(getApplicationContext());



    }
}