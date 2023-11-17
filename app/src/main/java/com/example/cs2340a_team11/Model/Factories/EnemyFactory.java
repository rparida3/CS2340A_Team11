package com.example.cs2340a_team11.Model.Factories;

import com.example.cs2340a_team11.Model.Enemies.Enemy;

public abstract class EnemyFactory {
    public Enemy prepareEnemy() {
        Enemy enemy = createEnemy();
        return enemy;
    }
    public abstract Enemy createEnemy();
}
