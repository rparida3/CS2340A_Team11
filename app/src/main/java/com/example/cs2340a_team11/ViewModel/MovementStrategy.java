package com.example.cs2340a_team11.ViewModel;
import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;

public interface MovementStrategy {
    void move(Player player);
    void move(Bandit enemy);

    void move(Skeleton skeleton);

    void move(Nightborneidle nightborneidle);

    void move(EvilWizard evilWizard);
}
