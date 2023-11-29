package com.example.cs2340a_team11.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Model.Leaderboard;
import com.example.cs2340a_team11.Model.Player;

import java.util.ArrayList;

public class PauseScreenViewModel extends ViewModel {
    public int calcCurrentScore() {
        Player player = Player.getPlayer();
        return player.getScore();
    }

    public String getScores() {
        Player player = Player.getPlayer();
        Leaderboard leaderboard = Leaderboard.getInstance();
        leaderboard.addScore(player.getName(), calcCurrentScore());
        ArrayList topScores = leaderboard.getTopScores(5);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < topScores.size(); i++) {
            out.append(i + 1).append(". ").append(topScores.get(i)).append("\n\n");
        }
        return out.toString();
    }
}
