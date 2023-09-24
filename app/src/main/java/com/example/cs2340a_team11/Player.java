package com.example.cs2340a_team11;

import android.widget.EditText;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class Player {
    private double x;
    private double y;
    private double movement_speed;

    private int hp;
    private int charId;

    private String difficulty;
    private String name;
    private static Player player;


    private Player(int charId, String name) {
        this(0, 0, charId, "Easy", name);
    }

    // let 0 = wizard (default), 1 = assassin, 2 = knight
    private Player(double x, double y, int charId, String difficulty, String name) {
        this.name = name;
        this.charId = charId;

        this.x = x;

        this.y = y;

        this.difficulty = difficulty;

        if (this.charId == R.id.wizardButton) {
            this.movement_speed = 5;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement_speed = 10;
            this.hp = 20;
        } else {
            this.movement_speed = 8;
            this.hp = 50;
        }
        if (difficulty.equals("Medium")) {
            this.movement_speed *= .80;
            this.hp *= .80;
        } else if (difficulty.equals("Hard")) {
            this.movement_speed *= .60;
            this.hp *= .60;
        }
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(0, "");
        }
        return player;
    }

    public void moveUp() {
        setY(Math.max(0, getY() - movement_speed));
    }
    public void moveDown() {
        setY(Math.min(getY() + movement_speed, 720));
    }
    public void moveLeft() {
        setX(Math.max(0, getX() - movement_speed));
    }
    public void moveRight() {
        setX(Math.min(getX() + movement_speed, 720));
    }
    public double getMovementSpeed() {
        return this.movement_speed;
    }
    public void setMovementSpeed(double movement_speed) {
        this.movement_speed = movement_speed;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }
    public int getHP() {
        return this.hp;
    }
    public void setCharId(int charId) {
        this.charId = charId;
        if (this.charId == R.id.wizardButton) {
            this.movement_speed = 5;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement_speed = 10;
            this.hp = 20;
        } else {
            this.movement_speed = 8;
            this.hp = 50;
        }

    }
    public int getCharId() {
        return this.charId;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        this.setCharId(this.charId);
        if (difficulty.equals("Medium")) {
            hp *= 0.8;
            movement_speed *= 0.8;
        } else if (difficulty.equals("Hard")) {
            hp *= 0.6;
            movement_speed *= 0.6;
        }

    }
    public String getDifficulty() {
        return this.difficulty;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
