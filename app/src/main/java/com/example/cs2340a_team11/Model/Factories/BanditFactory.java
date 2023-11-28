package com.example.cs2340a_team11.Model.Factories;

import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Enemies.Enemy;

public class BanditFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Bandit();
    }
}
