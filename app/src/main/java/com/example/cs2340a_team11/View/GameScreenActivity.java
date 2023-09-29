package com.example.cs2340a_team11.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;

public class GameScreenActivity extends AppCompatActivity {
    private Player player = Player.getPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        int charId = player.getCharId();
        Button endButton = (Button) findViewById(R.id.exitButton);
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);

        healthBar.setProgress(Player.getPlayer().getHP());
        nameView.setText(Player.getPlayer().getName());
        if (charId == 0) {
            characterView.setImageResource(R.drawable.wizard);
        } else if (charId == 1) {
            characterView.setImageResource(R.drawable.samurai);
        } else if (charId == 2) {
            characterView.setImageResource(R.drawable.knight);
        }

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressToEndScreen();
            }
        });
    }

    public void progressToEndScreen() {
        Intent progressToEndIntent = new Intent(this, EndingActivity.class);
        startActivity(progressToEndIntent);
    }




}


