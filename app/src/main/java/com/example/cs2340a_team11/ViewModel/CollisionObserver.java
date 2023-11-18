package com.example.cs2340a_team11.ViewModel;
import android.view.View;

import com.example.cs2340a_team11.Model.Enemy;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.View.PowerUpViews.HealthIncreaseView;


public interface CollisionObserver {
    void collision(Player player, MovementStrategy movementStrategy);
    boolean checkEnemyCollision(Player player, Enemy enemy);

}
