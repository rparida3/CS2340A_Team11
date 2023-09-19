package com.example.cs2340a_team11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Initial_Config_Screen extends AppCompatActivity {

    TextView nameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config_screen);

        nameBox = (TextView) findViewById(R.id.nameBox);

        nameBox.setText("What is your name?");


        Button easy = new Button(getApplicationContext());
        Button medium = new Button(getApplicationContext());
        Button hard = new Button(getApplicationContext());

    }
}