package com.example.cs2340a_team11.Model;

public class EvilWizard extends Enemy {

    private int stepSize;
    private float x;
    private float y;
    private float movement;

    public EvilWizard(int stepSize) {
        this.stepSize = stepSize;
    }

    public void setNewStepSize() {
        this.stepSize = (int) (Math.random() * 3) + 1;
    }

    public void changeColor() {
        ;
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
        setY(getY() - 120);
    }
    public void moveDown() {
        setY(getY() + 120);
    }
    public void moveLeft() {
        setX(getX() - 120);
    }
    public void moveRight() {
        setX(getX() + 120);
    }

}
