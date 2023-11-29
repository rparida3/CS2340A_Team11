package com.example.cs2340a_team11.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.Maps.MapFinalActivity;
import com.example.cs2340a_team11.View.Maps.MapOneActivity;
import com.example.cs2340a_team11.View.Maps.MapTwoActivity;
import com.example.cs2340a_team11.ViewModel.PauseScreenViewModel;

public class PauseScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PauseScreenViewModel pauseScreenViewModel;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_screen);
        pauseScreenViewModel = new ViewModelProvider(this).get(PauseScreenViewModel.class);

        TextView currentScore = findViewById(R.id.curr_score);
        currentScore.setText("Current Score: "
                + pauseScreenViewModel.calcCurrentScore());

        TextView scoreList = findViewById(R.id.current_stats);
        scoreList.setText(pauseScreenViewModel.getScores());

        Button resumeButton = findViewById(R.id.resume_button);
        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumeGame();
            }
        });
    }

    public void resumeGame() {
        // Resume game as-is
        // Get state of game screen
        Intent resume = getIntent();

        // Get the current map
        String map = resume.getStringExtra("activity");

        // Set the map activity according to current map
        if (map.equals("mapOne")) {
            resume = new Intent(this, MapOneActivity.class);
        } else if (map.equals("mapTwo")) {
            resume = new Intent(this, MapTwoActivity.class);
        } else if (map.equals("mapFinal")) {
            resume = new Intent(this, MapFinalActivity.class);
        } else {
            // If no map selected, default to first map
            resume = new Intent(this, MapOneActivity.class);
        }
        // Set screen to game screen
        startActivity(resume);
    }
}