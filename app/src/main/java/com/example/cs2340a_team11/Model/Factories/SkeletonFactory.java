package com.example.cs2340a_team11.Model.Factories;

import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;
import com.example.cs2340a_team11.Model.Factories.EnemyFactory;

public class SkeletonFactory extends EnemyFactory {

    @Override
    public Enemy createEnemy() {
        return new Skeleton();
    }
}
