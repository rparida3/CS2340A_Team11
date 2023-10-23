package com.example.cs2340a_team11.ViewModel;

import com.example.cs2340a_team11.Model.Player;

public class MoveUpStrategy implements MovementStrategy {
    @Override
    public void move(Player player) {
        player.moveUp();
    }
}
