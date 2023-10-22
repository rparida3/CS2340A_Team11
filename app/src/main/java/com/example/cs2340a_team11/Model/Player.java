package com.example.cs2340a_team11.Model;


import com.example.cs2340a_team11.R;

public class Player {
    private int score = 0;
    private float x;
    private float y;
    private float movement;
    private int hp;
    private int charId;
    private String difficulty;
    private String name;
    private static Player player;

    private Player(int charId, String name) {
        this(0, 0, R.id.wizardButton, "Easy", name);
    }

    private Player(float x, float y, int charId, String difficulty, String name) {
        this.name = name;
        this.charId = charId;

        this.x = x;

        this.y = y;

        this.difficulty = difficulty;

        if (this.charId == R.id.wizardButton) {
            this.movement = 25;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement = 50;
            this.hp = 20;
        } else {
            this.movement = 40;
            this.hp = 50;
        }
        if (difficulty.equals("Medium")) {
            this.hp *= .80;
        } else if (difficulty.equals("Hard")) {
            this.hp *= .60;
        }
    }

    public static synchronized Player getPlayer() {
        if (player == null) {
            player = new Player(R.id.wizardButton, "");
        }
        return player;
    }

    public void moveUp() {
        setY(getY() - 160);
    }
    public void moveDown() {
        setY(getY() + 160);
    }
    public void moveLeft() {
        setX(getX() - 160);
    }
    public void moveRight() {
        setX(getX() + 160);
    }

    public float getMovement() {
        return this.movement;
    }
    public void setMovement(float movementSpeed) {
        this.movement = movementSpeed;
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
    public void displayPosition() {
        System.out.println("Player position... X:" + player.getX() + "/ Y:" + player.getY());
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
            this.movement = 50;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement = 100;
            this.hp = 20;
        } else {
            this.movement = 80;
            this.hp = 50;
        }
        if (difficulty.equals("Medium")) {
            hp *= 0.8;
        } else if (difficulty.equals("Hard")) {
            hp *= 0.6;
        }

    }
    public int getCharId() {
        return this.charId;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        this.setCharId(charId);
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

    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
