package com.example.cs2340a_team11.Model;

public class Skeleton implements Enemy {

    private float x;
    private float y;

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

    @Override
    public void attack() {

    }

    @Override
    public void moveLeft() {
        this.setX(this.getX() - 150);
    }

    @Override
    public void moveRight() {
        this.setX(this.getX() + 150);
    }

    @Override
    public void moveUp() {
        this.setY(this.getY() + 150);
    }

    @Override
    public void moveDown() {
        this.setY(this.getY() + 150);
    }
}
