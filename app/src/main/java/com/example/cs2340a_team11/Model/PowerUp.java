package com.example.cs2340a_team11.Model;

abstract class PowerUp {
    protected Player player;


    public PowerUp(Player player) {
        this.player = player;
    }

    public boolean collided() {
        return false;
    }
}
