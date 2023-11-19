package com.example.cs2340a_team11.Model;

import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.View.EntityViews.EnemyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnemyList {
    private static EnemyList eList;
    private ArrayList<Enemy> enemies;
    public Map<Enemy, EnemyView> enemyViewMap = new HashMap<>();
    private EnemyList() {
        enemies = new ArrayList<Enemy>();
    }

    public static EnemyList getEList() {
        if (eList == null) {
            eList = new EnemyList();
        }
        return eList;
    }

    public void addEnemy(Enemy enemy, EnemyView view) {
        enemyViewMap.put(enemy, view);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void resetEnemies() {
        // gameLayout.removeView(enemyViewMap.get(enemy));
        // eList.getEnemies().remove(enemy); // or i

        for (Enemy enemy : enemies) {
            enemies.remove(enemy);
            enemy = null;
        }
        enemies = new ArrayList<>();
    }
}
