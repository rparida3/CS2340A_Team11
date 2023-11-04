package com.example.cs2340a_team11.Model;

public class EvilWizardFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new EvilWizard();
    }
}
