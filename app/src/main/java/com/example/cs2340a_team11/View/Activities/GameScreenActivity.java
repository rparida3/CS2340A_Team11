package com.example.cs2340a_team11.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.Maps.MapOneActivity;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;


public class GameScreenActivity extends AppCompatActivity {
    private static Context gameContext;
    private Player player = Player.getPlayer();
    private GameScreenViewModel gameScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);

        ConstraintLayout layout = findViewById(R.id.backgroundLayout);

        healthBar.setProgress(player.getHP());
        nameView.setText(player.getName());

        characterView.setImageResource(gameScreenViewModel.getImg());


        TextView healthText = findViewById(R.id.healthText);
        TextView healthPercentage = findViewById(R.id.healthPercentage);

        int newHealth = 50;
        int maxHealth = 100;

        healthBar.setProgress(newHealth);

        healthText.setText("Health: " + newHealth + "/" + maxHealth);

        int percentage = (int) ((newHealth / (float) maxHealth) * 100);
        healthPercentage.setText(percentage + "%");

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                gameScreenViewModel.stopTimer();
                progressToMapOne();
            }
        });

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.runTimer(timeView);
    }


    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToMapOne() {
        Intent progressToMapOneIntent = new Intent(this, MapOneActivity.class);
        startActivity(progressToMapOneIntent);
    }
}


