package com.example.cs2340a_team11.ViewModel;

import android.os.Handler;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;

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

    // DO PLEASE: method to update player health
}
