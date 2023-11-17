package com.example.cs2340a_team11.Model.Factories;

import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Factories.EnemyFactory;

public class EvilWizardFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new EvilWizard();
    }
}
