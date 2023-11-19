package com.example.cs2340a_team11.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.ViewModel.EndScreenViewModel;

public class GameOverActivity extends AppCompatActivity {
    private static Context gameContext;
    private Player player = Player.getPlayer();
    private EndScreenViewModel endScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_screen);
        endScreenViewModel = new ViewModelProvider(this).get(EndScreenViewModel.class);
        Button restart = (Button) findViewById(R.id.restart2);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
    }
    public void restartGame() {
        endScreenViewModel.resetScore();
        Intent restart = new Intent(this, StartScreen.class);
        startActivity(restart);
    }
}
