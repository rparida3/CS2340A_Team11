package com.example.cs2340a_team11.Model;

public class Nightborneidle extends Enemy {
    private boolean isVisible;
    private float x;
    private float y;
    private float movement;

    public Nightborneidle(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

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
        setY(getY() - 110);
    }
    public void moveDown() {
        setY(getY() + 110);
    }
    public void moveLeft() {
        setX(getX() - 110);
    }
    public void moveRight() {setX(getX() + 110);}
}
