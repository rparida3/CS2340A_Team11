package com.example.cs2340a_team11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.cs2340a_team11.Player;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Button endButton = (Button) findViewById(R.id.exitButton);
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);

        healthBar.setProgress(Player.getPlayer().getHP());
        nameView.setText(Player.getPlayer().getName());
        //characterView.setImageResource();
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


