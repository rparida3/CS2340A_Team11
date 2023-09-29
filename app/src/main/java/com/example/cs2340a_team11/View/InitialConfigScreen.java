package com.example.cs2340a_team11.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.ViewModel.InitialConfigViewModel;

public class InitialConfigScreen extends AppCompatActivity {
    private Player player = Player.getPlayer();
    private String playerName = "";
    private InitialConfigViewModel initialConfigViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config_screen);
        // reference the viewmodel
        initialConfigViewModel = new ViewModelProvider(this).get(InitialConfigViewModel.class);

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

                if (player.getDifficulty() == null) {
                    // default is easy in player class? default class is wizard?
                    System.out.println("Must select difficulty!");
                    return;
                }

                if (initialConfigViewModel.checkName(playerName)) {
                    startGame();
                }
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