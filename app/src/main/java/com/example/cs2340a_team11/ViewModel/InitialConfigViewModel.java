package com.example.cs2340a_team11.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Model.Player;

public class InitialConfigViewModel extends ViewModel {
    private Player player = Player.getPlayer();
    public InitialConfigViewModel() {

    }

    public boolean checkName(String playerName) {
        if (playerName.trim().isEmpty() || playerName == null || playerName.equals("")) {
            System.out.println("Input valid name, please!");
            return false;
        }
        player.setName(playerName);
        return true;
    }
}
