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
import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.EnemyList;
import com.example.cs2340a_team11.Model.Factories.BanditFactory;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Factories.EvilWizardFactory;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.Activities.GameOverActivity;
import com.example.cs2340a_team11.View.EntityViews.PlayerView;
import com.example.cs2340a_team11.View.EntityViews.BanditView;
import com.example.cs2340a_team11.View.EntityViews.EvilWizardView;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;
import com.example.cs2340a_team11.View.Activities.PauseScreen;

public class MapTwoActivity extends AppCompatActivity {
    private static Context gameContext;
    private Player player = Player.getPlayer();
    private BanditFactory bdFactory = new BanditFactory();
    private Bandit bandit = (Bandit) bdFactory.createEnemy();
    private EvilWizardFactory evFactory = new EvilWizardFactory();
    private EvilWizard evilWizard = (EvilWizard) evFactory.createEnemy();
    private PlayerView playerView;
    private BanditView banView;
    private EvilWizardView evView;
    private GameScreenViewModel gameScreenViewModel;
    private Wall walls = Wall.getWall();
    private EnemyList eList = EnemyList.getEList();
    private final int playerInitialHP = player.getInitialHP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_two);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);

        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        ConstraintLayout layout = findViewById(R.id.backgroundLayout);


        nameView.setText(player.getName());
        healthBar.setProgress((int) (100 * ((float) player.getHP() / playerInitialHP)));
        characterView.setImageResource(gameScreenViewModel.getImg());


        MapView mapView = new MapView(this, 1);
        MapView mapViewItem = new MapView(this, 13);
        layout.addView(mapView);
        layout.addView(mapViewItem);

        // offset the position of map to show in background AND below the info bar
        int offsetY = BitmapInterface.TILE_SIZE * 2;
        mapView.setZ(-1);
        mapView.setY(offsetY);
        mapViewItem.setY(offsetY);

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.runTimer(timeView);

        // render playerView
        gameScreenViewModel.setPlayerStarting(2);
        playerView = new PlayerView(this, player.getX(), player.getY(), player.getCharId());
        layout.addView(playerView);
        System.out.println("Player view added");
        playerView.bringToFront();

        bandit.setX(player.getX());
        bandit.setY(player.getY() - 3 * BitmapInterface.TILE_SIZE);
        banView = new BanditView(this, bandit.getX(), bandit.getY(), bandit);
        layout.addView(banView);
        System.out.println("Enemy view added");
        banView.bringToFront();
        gameScreenViewModel.runMovement(banView, walls.getWalls(), bandit);

        evilWizard.setX(player.getX() + 2 * BitmapInterface.TILE_SIZE);
        evilWizard.setY(player.getY() - 3 * BitmapInterface.TILE_SIZE);
        evView = new EvilWizardView(this, evilWizard.getX(), evilWizard.getY(), evilWizard);
        layout.addView(evView);
        System.out.println("Enemy view added");
        evView.bringToFront();

        eList.addEnemy(bandit, banView);
        eList.addEnemy(evilWizard, evView);

        gameScreenViewModel.runMovement(evView, walls.getWalls(), evilWizard);
        gameScreenViewModel.updatePlayerHealth(healthBar);
        gameScreenViewModel.getIsGameOver().observe(this, isGameOver -> {
            if (isGameOver) {
                gameScreenViewModel.stopTimer();
                endGame();
            }
        });
        gameScreenViewModel.checkGameOver();

        Button attackBtn = (Button) findViewById(R.id.attackBtn);
        attackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


    public static Context getGameContext() {
        return gameContext;
    }

    public void progressToNextMap() {
        Intent progressToMapFinalIntent = new Intent(this, MapFinalActivity.class);
        walls.resetWalls();
        walls.setIsDrawn(false);
        gameScreenViewModel.stopMovement();
        startActivity(progressToMapFinalIntent);
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        gameScreenViewModel.onKeyDown(keycode, event, playerView, walls.getWalls());
        if (gameScreenViewModel.checkDoor()) {
            gameScreenViewModel.stopTimer();
            progressToNextMap();
        }
        return true;
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
        pauseGameIntent.putExtra("activity", "mapTwo");
        startActivity(pauseGameIntent);
    }
}

