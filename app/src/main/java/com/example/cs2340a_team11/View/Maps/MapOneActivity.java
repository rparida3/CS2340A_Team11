package com.example.cs2340a_team11.View.Maps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.EnemyList;
import com.example.cs2340a_team11.Model.Factories.NightborneidleFactory;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Factories.NightborneidleFactory;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;
import com.example.cs2340a_team11.Model.Factories.SkeletonFactory;
import com.example.cs2340a_team11.Model.PowerUpModels.HealthIncrease;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;
import com.example.cs2340a_team11.Model.Factories.SkeletonFactory;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.Activities.GameOverActivity;
import com.example.cs2340a_team11.View.Activities.PauseScreen;
import com.example.cs2340a_team11.View.EntityViews.BanditView;
import com.example.cs2340a_team11.View.EntityViews.NightborneidleView;
import com.example.cs2340a_team11.View.EntityViews.PlayerView;
import com.example.cs2340a_team11.View.PowerUpViews.Views.HealthIncreaseView;
import com.example.cs2340a_team11.View.EntityViews.SkeletonView;
import com.example.cs2340a_team11.View.Activities.GameOverActivity;
import com.example.cs2340a_team11.View.EntityViews.NightborneidleView;
import com.example.cs2340a_team11.View.EntityViews.PlayerView;
import com.example.cs2340a_team11.View.EntityViews.SkeletonView;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;

public class MapOneActivity extends AppCompatActivity {
    private static Context gameContext;
    private PlayerView playerView;
    private Player player = Player.getPlayer();
    private SkeletonView skellyView;
    private NightborneidleView nbView;
    private NightborneidleFactory nbFactory = new NightborneidleFactory();
    private Nightborneidle nightborne = (Nightborneidle) nbFactory.createEnemy();
    private SkeletonFactory skFactory = new SkeletonFactory();
    private Skeleton skeleton = (Skeleton) skFactory.createEnemy();

    private BanditView banditView;

    private HealthIncrease healthIncrease;
    private HealthIncreaseView healthIncreaseView;

    private GameScreenViewModel gameScreenViewModel;
    private KeyEvent keyEvent;
    private Wall walls = Wall.getWall();
    private EnemyList eList = EnemyList.getEList();

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_one);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);
        TextView diffView = (TextView) findViewById(R.id.difficultyDisplay);
        diffView.setText("Difficulty: " + player.getDifficulty());
        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        layout = findViewById(R.id.backgroundLayout);

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
        gameScreenViewModel.updateScore(timeView);

        // render playerView
        gameScreenViewModel.setPlayerStarting(1);
        playerView = new PlayerView(this, player.getX(), player.getY(), player.getCharId());
        layout.addView(playerView);
        System.out.println("Player view added");
        playerView.bringToFront();

        skeleton.setY(player.getY() - 2 * BitmapInterface.TILE_SIZE);
        skeleton.setX(player.getX() - 3 * BitmapInterface.TILE_SIZE);
        skellyView = new SkeletonView(this, skeleton.getX(), skeleton.getY(), skeleton);
        layout.addView(skellyView);
        System.out.println("Skelly view added");
        skellyView.bringToFront();
        gameScreenViewModel.runMovement(skellyView, walls.getWalls(), skeleton);

        nightborne.setX(player.getX() - 2 * BitmapInterface.TILE_SIZE);
        nightborne.setY(player.getY() - 2 * BitmapInterface.TILE_SIZE);
        nbView = new NightborneidleView(this, nightborne.getX(), nightborne.getY(), nightborne);
        healthIncreaseView = new HealthIncreaseView(this,
                player.getX() + 1 * BitmapInterface.TILE_SIZE,
                player.getY() + 1 * BitmapInterface.TILE_SIZE, healthIncrease);
        layout.addView(healthIncreaseView);
        healthIncreaseView.bringToFront();








        nbView = new NightborneidleView(this,
                player.getX() - 2 * BitmapInterface.TILE_SIZE,
                player.getY() - 2 * BitmapInterface.TILE_SIZE, nightborne);
        layout.addView(nbView);
        System.out.println("Nb view added");
        nbView.bringToFront();
        gameScreenViewModel.runMovement(nbView, walls.getWalls(), nightborne);

        eList.addEnemy(nightborne, nbView);
        eList.addEnemy(skeleton, skellyView);

        gameScreenViewModel.updatePlayerHealth(healthBar);
        gameScreenViewModel.getIsGameOver().observe(this, isGameOver -> {
            if (isGameOver) {
                endGame();
            }
        });
        gameScreenViewModel.checkGameOver();

        Button attackBtn = (Button) findViewById(R.id.attackBtn);
        attackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gameScreenViewModel.attack(playerView);
                gameScreenViewModel.checkAttackCollision(layout, playerView);
            }
        });

        // Pause button
        Button pauseBtn = (Button) findViewById(R.id.pauseBtn);

        // Pause button listener
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToPauseScreen();
            }
        });
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        gameScreenViewModel.onKeyDown(keycode, event, playerView, walls.getWalls());
        if (gameScreenViewModel.checkDoor()) {
            progressToNextMap();
        }
        if (gameScreenViewModel.checkPowerUp(healthIncreaseView)) {
            player.setHP(player.getHP() + 10);
            layout.removeView(healthIncreaseView);
        }

        return true;
    }

    // still not sure what this does lol
    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToNextMap() {
        Intent progressToMapTwoIntent = new Intent(this, MapTwoActivity.class);
        walls.resetWalls();
        walls.setIsDrawn(false);
        gameScreenViewModel.stopMovement();
        startActivity(progressToMapTwoIntent);
    }

    public void endGame() {
        Intent progressToGameOverScreen = new Intent(this, GameOverActivity.class);
        walls.resetWalls();
        walls.setIsDrawn(false);
        gameScreenViewModel.stopMovement();
        startActivity(progressToGameOverScreen);
        finish();
    }

    // Method for moving to pause screen activity
    public void moveToPauseScreen() {
        gameScreenViewModel.stopTimer();
        Intent pauseGameIntent = new Intent(this, PauseScreen.class);
        pauseGameIntent.putExtra("activity", "mapOne");
        startActivity(pauseGameIntent);
    }
}
