package com.example.cs2340a_team11.ViewModel;

import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;

public class MoveDownStrategy implements MovementStrategy {
    @Override
    public void move(Player player) {
        player.moveDown();
    }

    @Override
    public void move(Bandit bandit) {
        bandit.moveDown();
    }

    @Override
    public void move(Skeleton skeleton) {
        skeleton.moveDown();
    }

    @Override
    public void move(Nightborneidle nightborneidle) {
        nightborneidle.moveDown();
    }

    @Override
    public void move(EvilWizard evilWizard) {
        evilWizard.moveDown();
    }
}
