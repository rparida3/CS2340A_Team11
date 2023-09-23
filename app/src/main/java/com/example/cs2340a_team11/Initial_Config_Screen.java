package com.example.cs2340a_team11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Initial_Config_Screen extends AppCompatActivity {
    Player player = Player.getPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config_screen);


        TextView nameBox = (TextView) findViewById(R.id.nameBox);

        nameBox.setText("What is your name?");
        Button easy = (Button) findViewById(R.id.Easy);
        Button medium = (Button) findViewById(R.id.Medium);
        Button hard = (Button) findViewById(R.id.Hard);
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
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        int id = view.getId();
        if (checked) {
            if (id == R.id.wizardButton || id == R.id.assassinButton || id == R.id.knightButton) {
                player.setCharId(id);
            }
        }
    }

}