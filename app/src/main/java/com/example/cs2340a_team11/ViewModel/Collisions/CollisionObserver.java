package com.example.cs2340a_team11.ViewModel.Collisions;

import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.Model.Player;


public interface CollisionObserver {
    void collision(Player player, MovementStrategy movementStrategy);
    boolean checkEnemyCollision(Player player, Enemy enemy);
}
