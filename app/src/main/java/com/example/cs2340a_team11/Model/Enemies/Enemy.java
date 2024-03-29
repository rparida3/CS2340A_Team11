package com.example.cs2340a_team11.Model.Enemies;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;

public abstract class Enemy {
    private float x;
    private float y;
    private Player player = Player.getPlayer();

    private int charId; // 0 = Bandit, 1 = EvilWizard, 2 = Nightborneidle, 3 = Skeleton

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    // MAY WANT TO OVERRIDE THIS IN EACH ENEMY FOR DIFF DAMAGE
    public void enemyAttack() {
        if (player.getDifficulty().equals("Easy")) {
            player.setHP(player.getHP() - 5);
        } else if (player.getDifficulty().equals("Medium")) {
            player.setHP(player.getHP() - 8);
        } else {
            player.setHP(player.getHP() - 12);
        }
    }

    public void moveUp() {
        setY(getY() - BitmapInterface.TILE_SIZE);
    }
    public void moveDown() {
        setY(getY() + BitmapInterface.TILE_SIZE);
    }
    public void moveLeft() {
        setX(getX() - BitmapInterface.TILE_SIZE);
    }
    public void moveRight() {
        setX(getX() + BitmapInterface.TILE_SIZE);
    }

    public void displayPosition() {
        System.out.println("X: " + x + ". Y: " + y);
    }
}
