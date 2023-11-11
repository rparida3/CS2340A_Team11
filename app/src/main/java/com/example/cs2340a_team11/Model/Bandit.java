package com.example.cs2340a_team11.Model;

public class Bandit extends Enemy {
    private float x;
    private float y;
    private float movement;
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void moveUp() {
        setY(getY() - 130);
    }
    public void moveDown() {
        setY(getY() + 130);
    }
    public void moveLeft() {
        setX(getX() - 130);
    }
    public void moveRight() {
        setX(getX() + 130);
    }

    public float getMovement() {
        return this.movement;
    }
    public void setMovement(float movementSpeed) {
        this.movement = movementSpeed;
    }
}
