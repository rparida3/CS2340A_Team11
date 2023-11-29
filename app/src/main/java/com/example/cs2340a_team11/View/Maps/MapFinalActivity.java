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
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.EnemyList;
import com.example.cs2340a_team11.Model.Factories.EvilWizardFactory;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Factories.NightborneidleFactory;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.Activities.EndingActivity;
import com.example.cs2340a_team11.View.Activities.GameOverActivity;
import com.example.cs2340a_team11.View.EntityViews.EvilWizardView;
import com.example.cs2340a_team11.View.EntityViews.NightborneidleView;
import com.example.cs2340a_team11.View.EntityViews.PlayerView;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;
import com.example.cs2340a_team11.View.Activities.PauseScreen;
import com.example.cs2340a_team11.View.PowerUpViews.Views.CoinView;
public class MapFinalActivity extends AppCompatActivity {
    private static Context gameContext;
    private Player player = Player.getPlayer();
    private NightborneidleFactory nbFactory = new NightborneidleFactory();
    private Nightborneidle nightborne = (Nightborneidle) nbFactory.createEnemy();
    private EvilWizardFactory evilWizardFactory = new EvilWizardFactory();
    private EvilWizard evilWizard = (EvilWizard) evilWizardFactory.createEnemy();
    private PlayerView playerView;
    private GameScreenViewModel gameScreenViewModel;
    private Wall walls = Wall.getWall();
    private final int playerInitialHP = player.getInitialHP();
    private EnemyList eList = EnemyList.getEList();
    private CoinView coinView;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_final);
        gameContext = this;
        gameScreenViewModel = new ViewModelProvider(this).get(GameScreenViewModel.class);

        ImageView characterView = (ImageView) findViewById(R.id.character_photo);
        TextView nameView = (TextView) findViewById(R.id.name);
        ProgressBar healthBar = (ProgressBar) findViewById(R.id.healthBar);
        layout = findViewById(R.id.backgroundLayout);
        TextView diffView = (TextView) findViewById(R.id.difficultyDisplay);
        diffView.setText("Difficulty: " + player.getDifficulty());


        nameView.setText(player.getName());
        healthBar.setProgress((int) (100 * ((float) player.getHP() / playerInitialHP)));
        characterView.setImageResource(gameScreenViewModel.getImg());


        MapView mapView = new MapView(this, 3);
        MapView mapViewItem = new MapView(this, 14);
        layout.addView(mapView);
        layout.addView(mapViewItem);

        // offset the position of map to show in background AND below the info bar
        int offsetY = BitmapInterface.TILE_SIZE * 2;
        mapView.setZ(-1);
        mapView.setY(offsetY);
        mapViewItem.setY(offsetY);

        TextView timeView = findViewById(R.id.scoreUpdate);
        gameScreenViewModel.updateScore(timeView);

        // render playerView
        gameScreenViewModel.setPlayerStarting(3);
        playerView = new PlayerView(this, player.getX(), player.getY(), player.getCharId());
        layout.addView(playerView);
        System.out.println("Player view added");
        playerView.bringToFront();

        evilWizard.setX(player.getX());
        evilWizard.setY(player.getY() + BitmapInterface.TILE_SIZE);
        EvilWizardView evView = new EvilWizardView(this,
                evilWizard.getX(),
                evilWizard.getY(), evilWizard);
        layout.addView(evView);
        System.out.println("Enemy view added");
        evView.bringToFront();
        gameScreenViewModel.runMovement(evView, walls.getWalls(), evilWizard);

        nightborne.setX(player.getX() + BitmapInterface.TILE_SIZE);
        nightborne.setY(player.getY());
        NightborneidleView nbView = new NightborneidleView(this,
                nightborne.getX(),
                nightborne.getY(), nightborne);
        layout.addView(nbView);
        System.out.println("Enemy view added");
        nbView.bringToFront();
        gameScreenViewModel.runMovement(nbView, walls.getWalls(), nightborne);

        eList.addEnemy(nightborne, nbView);
        eList.addEnemy(evilWizard, evView);

        gameScreenViewModel.updatePlayerHealth(healthBar);
        gameScreenViewModel.getIsGameOver().observe(this, isGameOver -> {
            if (isGameOver) {
                endGame();
            }
        });
        gameScreenViewModel.checkGameOver();
        coinView = new CoinView(this,
                player.getX() + BitmapInterface.TILE_SIZE,
                player.getY() + BitmapInterface.TILE_SIZE);
        layout.addView(coinView);
        coinView.bringToFront();
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

    public void progressToEndScreen() {
        Intent progressToEndIntent = new Intent(this, EndingActivity.class);
        walls.resetWalls();
        walls.setIsDrawn(false);
        gameScreenViewModel.stopMovement();
        startActivity(progressToEndIntent);
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        gameScreenViewModel.onKeyDown(keycode, event, playerView, walls.getWalls());
        if (gameScreenViewModel.checkDoor()) {
            progressToEndScreen();
        }
        if (gameScreenViewModel.checkPowerUp(coinView)) {
            gameScreenViewModel.setScoreMultiplier();
            layout.removeView(coinView);
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
        gameScreenViewModel.stopMovement();

        Intent pauseGameIntent = new Intent(this, PauseScreen.class);
        pauseGameIntent.putExtra("activity", "mapFinal");
        startActivity(pauseGameIntent);
    }
}
