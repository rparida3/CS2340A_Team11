package com.example.cs2340a_team11.View.Maps;

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

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.EndingActivity;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;

public class MapFinalActivity extends AppCompatActivity {

    private static Context gameContext;
    private Player player = Player.getPlayer();
    private GameScreenViewModel gameScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_final);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);

        Button endButton = (Button) findViewById(R.id.endBtn);
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        ConstraintLayout layout = findViewById(R.id.backgroundLayout);

        healthBar.setProgress(player.getHP());
        nameView.setText(player.getName());

        characterView.setImageResource(gameScreenViewModel.getImg());




        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameScreenViewModel.stopTimer();
                progressToEndScreen();
            }
        });

        MapView mapView = new MapView(this, 3);
        layout.addView(mapView);

        mapView.setZ(-1);
        mapView.setY(BitmapInterface.TILE_SIZE * 2);

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.runTimer(timeView);
    }


    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToEndScreen() {
        Intent progressToEndIntent = new Intent(this, EndingActivity.class);
        startActivity(progressToEndIntent);
    }
}
