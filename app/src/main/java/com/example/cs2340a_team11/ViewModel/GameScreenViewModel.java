package com.example.cs2340a_team11.ViewModel;

import android.graphics.Rect;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.PlayerView;

import java.util.ArrayList;

public class GameScreenViewModel extends ViewModel {
    private Player player = Player.getPlayer();

    private int charId = player.getCharId();

    private int totalScore = player.getScore();
    // private MapView mapView;
    private ArrayList<Rect> walls = new ArrayList<Rect>();

    private Handler handler = new Handler();
    private boolean isTimerRunning = true;
    public GameScreenViewModel() {

    }

    public int getImg() {
        System.out.println(charId);
        if (charId == R.id.wizardButton) {
            return R.drawable.wizard;
        } else if (charId == R.id.assassinButton) {
            return R.drawable.samurai;
        } else if (charId == R.id.knightButton) {
            return R.drawable.knight;
        }
        return R.drawable.wizard;
    }

    public void setPlayerStarting(int mapLevel) {
        if (mapLevel == 1) {
            // sets in [4][3] of mapView array
            player.setY(4 * BitmapInterface.TILE_SIZE + 320);
            player.setX(3 * BitmapInterface.TILE_SIZE);
        } else if (mapLevel == 2) {
            // sets in [6][1]
            player.setY(6 * BitmapInterface.TILE_SIZE + 320);
            player.setX(BitmapInterface.TILE_SIZE);
        } else if (mapLevel == 3) {
            // sets in [1][1]
            player.setY(BitmapInterface.TILE_SIZE + 320);
            player.setX(BitmapInterface.TILE_SIZE);
        } else {
            player.setY(320);
            player.setX(0);
        }
        player.displayPosition();
    }

    public void runTimer(TextView timeView) {
        handler.post(new Runnable() {
            @Override

            public void run() {
                totalScore++;
                player.setScore(totalScore);
                String score = Integer.toString(totalScore);
                timeView.setText(score);
                if (isTimerRunning) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }
    public void stopTimer() {
        isTimerRunning = false;
        handler.removeCallbacksAndMessages(null);
    }

    public void onKeyDown(int keyCode, KeyEvent event, PlayerView view, ArrayList<Rect> walls) {
        // player.displayPosition();
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            player.moveLeft();
            if (checkCollision(player, walls)) {
                System.out.println("Collision!!!");
                player.moveRight();
                // cancel left movement by calling moveRight()
            }
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            player.moveRight();
            if (checkCollision(player, walls)) {
                System.out.println("Collision!!!");
                player.moveLeft();
            }
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            player.moveUp();
            if (checkCollision(player, walls)) {
                System.out.println("Collision!!!");
                player.moveDown();
            }
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            player.moveDown();
            if (checkCollision(player, walls)) {
                System.out.println("Collision!!!");
                player.moveUp();
            }
            break;
        default:
            break;
        }
        view.updatePosition(player.getX(), player.getY());
    }

    // if collide, collision is true
    public boolean checkCollision(Player player, ArrayList<Rect> walls) {
        Rect r1 = new Rect((int) player.getX(),
                (int) player.getY() - 320,
                (int) player.getX() + 160,
                (int) player.getY() - 160);
        System.out.println("Player rect: " + r1);
        for (Rect wall : walls) {
            if (r1.intersect(wall)) {
                System.out.println("INTERSECT IS TRUE");
                System.out.println("Wall rect: " + wall);
                return true;
            }
        }
        return false;
    }

    /*
    public boolean checkCollision(PlayerView view, ArrayList<Rect> walls) {
        Rect r1 = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        System.out.println("Player rect: " + r1);
        System.out.println(walls.size());
        for (Rect wall : walls) {
            if (wall.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                System.out.println("Wall rect: " + wall);
                System.out.println("INTERSECT IS TRUE");
                return true;
            }
        }
        return false;
    }
     */


    // DO PLEASE: method to update player health
}
