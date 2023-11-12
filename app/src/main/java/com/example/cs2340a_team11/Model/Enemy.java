package com.example.cs2340a_team11.Model;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.R;

public abstract class Enemy {
    private float x;
    private float y;
    private Player player = Player.getPlayer();

    float getX() {
        return x;
    }
    void setX(float x) {
        this.x = x;
    }
    float getY() {
        return y;
    }
    void setY(float y) {
        this.y = y;
    }

    // MAY WANT TO OVERRIDE THIS IN EACH ENEMY FOR DIFF DAMAGE
    void attack() {
        player.setHP(player.getHP() - 1);
    }

    public void moveLeft() {
        this.setX(this.getX() - BitmapInterface.TILE_SIZE);
    }

    public void moveRight() {
        this.setX(this.getX() + BitmapInterface.TILE_SIZE);
    }

    public void moveUp() {
        this.setY(this.getY() + BitmapInterface.TILE_SIZE);
    }

    public void moveDown() {
        this.setY(this.getY() + BitmapInterface.TILE_SIZE);
    }
}
