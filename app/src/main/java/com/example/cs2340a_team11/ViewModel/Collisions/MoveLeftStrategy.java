package com.example.cs2340a_team11.ViewModel.Collisions;

import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;

public class MoveLeftStrategy implements MovementStrategy {

    @Override
    public void move(Player player) {
        player.moveLeft();
    }
    @Override
    public void move(Bandit bandit) {
        bandit.moveLeft();
    }

    @Override
    public void move(Skeleton skeleton) {
        skeleton.moveLeft();
    }

    @Override
    public void move(Nightborneidle nightborneidle) {
        nightborneidle.moveLeft();
    }

    @Override
    public void move(EvilWizard evilWizard) {
        evilWizard.moveLeft();
    }
}
