package com.example.cs2340a_team11.Model;

public class SkeletonFactory extends EnemyFactory {

    @Override
    public Enemy createEnemy() {
        return new Skeleton();
    }
}
