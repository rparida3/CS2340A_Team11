package com.example.cs2340a_team11.ViewModel;
import com.example.cs2340a_team11.Model.Player;
import android.graphics.Rect;


public interface CollisionObserver {
    void collision(Player player, MovementStrategy movementStrategy);
}
