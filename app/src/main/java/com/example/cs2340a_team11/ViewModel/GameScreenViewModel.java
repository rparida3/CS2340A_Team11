package com.example.cs2340a_team11.ViewModel;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.PlayerView;

public class GameScreenViewModel extends ViewModel {
    private Player player = Player.getPlayer();

    private int charId = player.getCharId();

    private int totalScore = player.getScore();

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

    public boolean onKeyDown(int keyCode, KeyEvent event, PlayerView view) {
        player.displayPosition();
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            player.moveLeft();
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            player.moveRight();
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            player.moveUp();
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            player.moveDown();
            break;
        default:
            break;
        }
        view.updatePosition(player.getX(), player.getY());
        return true;
    }

    // DO PLEASE: method to update player health
}
