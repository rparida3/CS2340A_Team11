package com.example.cs2340a_team11.Model;

public class Nightborneidle extends Enemy {
    private boolean isVisible;

    public Nightborneidle(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
