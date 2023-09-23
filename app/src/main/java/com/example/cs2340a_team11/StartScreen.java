package com.example.cs2340a_team11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        //create activity_start_screen XML file

        TextView welcomeText = findViewById(R.id.welcomeText);
        /*Button startButton = findViewById(R.id.startButton);
        Button endButton = findViewById(R.id.endButton);
        Button quitButton = findViewById(R.id.quitButton);*/

        // Set text to something better if wanted
        welcomeText.setText("Welcome!");
    }

}
