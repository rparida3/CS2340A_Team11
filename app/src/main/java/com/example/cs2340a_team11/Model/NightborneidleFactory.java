package com.example.cs2340a_team11.Model;

public class NightborneidleFactory extends EnemyFactory {

    @Override
    public Enemy createEnemy() {
        return new Nightborneidle(true);
    }
}
