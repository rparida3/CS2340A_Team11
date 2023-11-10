package com.example.cs2340a_team11.Model;

public class EvilWizard extends Enemy {

    private int stepSize;
    private int[] colors;

    public EvilWizard(int stepSize) {
        this.stepSize = stepSize;
        this.colors(new int[255, 255, 255]);
    }

    public void setNewStepSize() {
        this.stepSize = (int) (Math.random() * 3) + 1;
    }

    public void changeColor() {
        ;
    }

}
