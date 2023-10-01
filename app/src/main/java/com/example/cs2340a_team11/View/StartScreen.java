package com.example.cs2340a_team11.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.InitialConfigScreen;

public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        //create activity_start_screen XML file

        TextView welcomeText = findViewById(R.id.welcomeText);
        Button startButton = findViewById(R.id.startButton);
        Button endButton = findViewById(R.id.endButton);
        Button quitButton = findViewById(R.id.quitButton);

        // Set text to something better if wanted
        welcomeText.setText("Welcome!");

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
                //welcomeText.setVisibility(View.GONE);
                //startButton.setVisibility(View.GONE);
                //endButton.setVisibility(View.VISIBLE);
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeText.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.VISIBLE);
                endButton.setVisibility(View.GONE);
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeText.setVisibility(View.GONE);
                startButton.setVisibility(View.GONE);
                endButton.setVisibility(View.GONE);
                finish();
            }
        });
    }

    private void startGame() {
        Intent initialConfigIntent = new Intent(this, InitialConfigScreen.class);
        startActivity(initialConfigIntent);
    }

}
