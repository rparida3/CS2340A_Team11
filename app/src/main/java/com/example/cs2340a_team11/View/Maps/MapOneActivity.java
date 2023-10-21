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
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;

public class MapOneActivity extends AppCompatActivity {

    private static Context gameContext;
    private Player player = Player.getPlayer();
    private GameScreenViewModel gameScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_one);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);

        Button nextButton = (Button) findViewById(R.id.nextBtn);
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        ConstraintLayout layout = findViewById(R.id.backgroundLayout);

        healthBar.setProgress(player.getHP());
        nameView.setText(player.getName());

        characterView.setImageResource(gameScreenViewModel.getImg());

        // Begin Movement
        ImageView player = (ImageView) findViewById(R.id.player);
        Button upButton = (Button) findViewById(R.id.upButton);
        Button downButton = (Button) findViewById(R.id.downButton);
        Button leftButton = (Button) findViewById(R.id.leftButton);
        Button rightButton = (Button) findViewById(R.id.rightButton);

        final int[] testX = {10};
        final int[] testY = {10};
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testY[0] -= 10;
                player.setY(testY[0]);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testY[0] += 10;
                player.setY(-10);
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testX[0] -= 10;
                player.setX(testX[0]);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testX[0] += 10;
                player.setX(testX[0]);
            }
        });


        // End Movement





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameScreenViewModel.stopTimer();
                progressToNextMap();
            }
        });

        MapView mapView = new MapView(this, 2);
        MapView mapViewItems = new MapView(this, 12);
        layout.addView(mapView);
        layout.addView(mapViewItems);

        // offset the position of map to show in background AND below the info bar
        mapView.setZ(-1);
        mapView.setY(BitmapInterface.TILE_SIZE * 2);
        mapViewItems.setY(BitmapInterface.TILE_SIZE * 2);

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.runTimer(timeView);
    }


    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToNextMap() {
        Intent progressToMapTwoIntent = new Intent(this, MapTwoActivity.class);
        startActivity(progressToMapTwoIntent);
    }
}
