package com.example.cs2340a_team11.ViewModel;


import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;

public class InitialConfigViewModel extends ViewModel {
    private Player player = Player.getPlayer();
    public InitialConfigViewModel() {

    }
    public void gameSetDifficulty(int id) {
        if (id == R.id.Easy) {
            player.setDifficulty("Easy");
        } else if (id == R.id.Medium) {
            player.setDifficulty("Medium");
        } else if (id == R.id.Hard) {
            player.setDifficulty("Hard");
        } else {
            player.setDifficulty("Easy");
        }
    }

    public boolean checkName(String playerName) {
        if (playerName == null || playerName.trim().isEmpty() || playerName.equals("")) {
            System.out.println("Input valid name, please!");
            return false;
        }
        player.setName(playerName);
        return true;
    }

    public void chooseChar(int id) {
        if (id == R.id.wizardButton || id == R.id.assassinButton || id == R.id.knightButton) {
            player.setCharId(id);
        } else {
            System.out.println("error");
        }
    }
}
