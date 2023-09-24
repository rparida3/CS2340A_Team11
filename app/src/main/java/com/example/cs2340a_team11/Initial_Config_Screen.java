package com.example.cs2340a_team11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Initial_Config_Screen extends AppCompatActivity {
    Player player = Player.getPlayer();
    String playerName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config_screen);


        //nameBox.setText("What is your name?"); // need to validate
        Button easy = (Button) findViewById(R.id.Easy);
        Button medium = (Button) findViewById(R.id.Medium);
        Button hard = (Button) findViewById(R.id.Hard);
        Button submitButton = (Button) findViewById(R.id.Submit);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setDifficulty("Easy");
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setDifficulty("Medium");
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setDifficulty("Hard");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nameBox = (TextView) findViewById(R.id.nameBox);
                playerName = nameBox.getText().toString();

                // may want to do private helper method?
                if (playerName.trim().isEmpty() || playerName == null || playerName.equals("")) {
                    System.out.println("Input valid name please!");
                    return;
                }
                player.setName(playerName);

                if (player.getDifficulty() == null) {
                    // default is easy in player class? default class is wizard?
                    System.out.println("Must select difficulty!");
                    return;
                }

                startGame();
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        int id = view.getId();
        if (checked) {
            /*
            if (id == R.id.wizardButton || id == R.id.assassinButton || id == R.id.knightButton) {
                player.setCharId(id);
            }
             */
            if (id == R.id.wizardButton) {
                player.setCharId(0);
            } else if (id == R.id.assassinButton) {
                player.setCharId(1);
            } else if (id == R.id.knightButton) {
                player.setCharId(2);
            } else {
                player.setCharId(0);
            }
        }
    }

    public void startGame() {
        Intent gameScreenIntent = new Intent(this, GameScreenActivity.class);
        System.out.println(playerName);
        startActivity(gameScreenIntent);
    }

}