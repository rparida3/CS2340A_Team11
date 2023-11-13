package com.example.cs2340a_team11.ViewModel;


import com.example.cs2340a_team11.Model.Enemy;
import com.example.cs2340a_team11.Model.Player;

import com.example.cs2340a_team11.Model.Skeleton;

public class CollisionHandler implements CollisionObserver {
    @Override
    public void collision(Player player, MovementStrategy movementStrategy) {
        System.out.println("Collision!");
        if (movementStrategy instanceof MoveLeftStrategy) {
            player.moveRight();
        } else if (movementStrategy instanceof MoveRightStrategy) {
            player.moveLeft();
        } else if (movementStrategy instanceof MoveUpStrategy) {
            player.moveDown();
        } else if (movementStrategy instanceof MoveDownStrategy) {
            player.moveUp();
        }
    }

    public void collision(Enemy enemy, MovementStrategy movementStrategy) {
        if (movementStrategy instanceof MoveLeftStrategy) {
            enemy.moveRight();
        } else if (movementStrategy instanceof MoveRightStrategy) {
            enemy.moveLeft();
        } else if (movementStrategy instanceof MoveUpStrategy) {
            enemy.moveDown();
        } else if (movementStrategy instanceof MoveDownStrategy) {
            enemy.moveUp();
        }
    }

}
