package com.example.cs2340a_team11.ViewModel;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.View.GameScreenActivity;

public class EndScreenViewModel extends ViewModel {
    private Player player = Player.getPlayer();
    public EndScreenViewModel() {
        Leaderboard leaderboard = Leaderboard.getInstance();
        leaderboard.addScore(player.getName(), calcTotalScore());
        ArrayList topScores = leaderboard.getTopScores(5);
    }

    // DO PLEASE: fetch results from player and return to view
    public String fetchResult() {
        return "won";
    }

    public int fetchKilled() {
        return 0;
    }

    public int fetchBoost() {
        return 0;
    }

    public int calcTotalScore() {
        return player.getScore();
    }
}
