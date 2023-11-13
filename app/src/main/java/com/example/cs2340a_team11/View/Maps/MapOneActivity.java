package com.example.cs2340a_team11.View.Maps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.GameOverActivity;
import com.example.cs2340a_team11.View.BanditView;
import com.example.cs2340a_team11.View.NightborneidleView;
import com.example.cs2340a_team11.View.PlayerView;
import com.example.cs2340a_team11.View.SkeletonView;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;



public class MapOneActivity extends AppCompatActivity {

    private PlayerView playerView;

    private SkeletonView skellyView;

    private NightborneidleView nbView;

    private static Context gameContext;
    private Player player = Player.getPlayer();

    private BanditView banditView;
    private GameScreenViewModel gameScreenViewModel;
    private KeyEvent keyEvent;
    private Wall walls = Wall.getWall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_one);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);


        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        ConstraintLayout layout = findViewById(R.id.backgroundLayout);

        healthBar.setProgress(player.getHP());
        nameView.setText(player.getName());

        characterView.setImageResource(gameScreenViewModel.getImg());


        MapView mapView = new MapView(this, 2);
        MapView mapViewItems = new MapView(this, 12);
        layout.addView(mapView);
        layout.addView(mapViewItems);

        // offset the position of map to show in background AND below the info bar
        int offsetY = BitmapInterface.TILE_SIZE * 2;
        mapView.setZ(-1);
        mapView.setY(offsetY);

        mapViewItems.setY(BitmapInterface.TILE_SIZE * 2);

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.runTimer(timeView);

        // render playerView
        gameScreenViewModel.setPlayerStarting(1);
        playerView = new PlayerView(this, player.getX(), player.getY(), player.getCharId());
        layout.addView(playerView);
        System.out.println("Player view added");

        playerView.bringToFront();

        skellyView = new SkeletonView(this,
                player.getX() - 3 * BitmapInterface.TILE_SIZE,
                player.getY() - 2 * BitmapInterface.TILE_SIZE);
        layout.addView(skellyView);
        System.out.println("Skelly view added");
        skellyView.bringToFront();
        gameScreenViewModel.runMovement(skellyView);

        nbView = new NightborneidleView(this,
                player.getX() - 2 * BitmapInterface.TILE_SIZE,
                player.getY() - 2 * BitmapInterface.TILE_SIZE);
        layout.addView(nbView);
        System.out.println("Nb view added");
        nbView.bringToFront();
        gameScreenViewModel.runMovement(nbView);
        gameScreenViewModel.updatePlayerHealth(healthBar);
        gameScreenViewModel.getPlayerHealth().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newHealth) {
                if (newHealth <= 0) {
                    gameScreenViewModel.stopTimer();
                    endGame();
                    finish();
                }
            }
        });
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        gameScreenViewModel.onKeyDown(keycode, event, playerView, walls.getWalls());
        if (gameScreenViewModel.checkDoor()) {
            gameScreenViewModel.stopTimer();
            // gameScreenViewModel.stopMovement();
            progressToNextMap();
        }
        return true;
    }
    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToNextMap() {
        Intent progressToMapTwoIntent = new Intent(this, MapTwoActivity.class);
        walls.resetWalls();
        walls.setIsDrawn(false);
        startActivity(progressToMapTwoIntent);
    }

    public void endGame() {
        Intent progressToGameOverScreen = new Intent(this, GameOverActivity.class);
        startActivity(progressToGameOverScreen);
    }
}
