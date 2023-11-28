package com.example.cs2340a_team11.Model.PowerUpModels;

import com.example.cs2340a_team11.Model.Player;

public class HealthIncrease extends PowerUp {

    Player player = Player.getPlayer();

    @Override
    public void powerUpAbility() {
        player.setHP(player.getHP() + 10);
    }
}
