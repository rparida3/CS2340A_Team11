package com.example.cs2340a_team11.Model;


import android.graphics.Bitmap;
import android.graphics.Color;


import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.R;


public class Player {
    private int score = 0;
    private double x;
    private double y;
    private double movement;

    private int hp;
    private int charId;

    private String difficulty;
    private String name;
    private static Player player;


    private Player(int charId, String name) {
        this(0, 0, R.id.wizardButton, "Easy", name);
    }

    // let 0 = wizard (default), 1 = assassin, 2 = knight
    private Player(double x, double y, int charId, String difficulty, String name) {
        this.name = name;
        this.charId = charId;

        this.x = x;

        this.y = y;

        this.difficulty = difficulty;

        if (this.charId == R.id.wizardButton) {
            this.movement = 5;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement = 10;
            this.hp = 20;
        } else {
            this.movement = 8;
            this.hp = 50;
        }
        if (difficulty.equals("Medium")) {
            this.movement *= .80;
            this.hp *= .80;
        } else if (difficulty.equals("Hard")) {
            this.movement *= .60;
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
        setY(Math.max(0, getY() - movement));
    }
    public void moveDown() {
        setY(Math.min(getY() + movement, 720));
    }
    public void moveLeft() {
        setX(Math.max(0, getX() - movement));
    }
    public void moveRight() {
        setX(Math.min(getX() + movement, 720));
    }
    public double getMovement() {
        return this.movement;
    }
    public void setMovement(double movementSpeed) {
        this.movement = movementSpeed;
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
            this.movement = 5;
            this.hp = 30;
        } else if (this.charId == R.id.assassinButton) {
            this.movement = 10;
            this.hp = 20;
        } else {
            this.movement = 8;
            this.hp = 50;
        }
        if (difficulty.equals("Medium")) {
            hp *= 0.8;
            movement *= 0.8;
        } else if (difficulty.equals("Hard")) {
            hp *= 0.6;
            movement *= 0.6;
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

    public boolean collisionDetection(double playerX, double playerY, Bitmap map) {
        Player player = getPlayer();
        BitmapInterface interfaceInstance = new BitmapInterface() {
            @Override
            public Bitmap getScaledBitmap(Bitmap bitmap) {
                return BitmapInterface.super.getScaledBitmap(bitmap);
            }
        };

        double playerPositionX = playerX;
        double playerPositionY = playerY;
        Bitmap bitmap = interfaceInstance.getScaledBitmap(null);
        // TODO: FIND out how to get or create bitmap object.

        // Calculate the map coordinates for the player's position
        for (int y = 0; y <= interfaceInstance.PIX_SIZE * bitmap.getHeight(); y++) {
            for (int x = 0; x <= interfaceInstance.PIX_SIZE * bitmap.getWidth(); x++) {
                // Ensure the coordinates are within the bounds of the map
                if (x >= 0 && y >= 0 && x < map.getWidth() && y < map.getHeight()) {
                    // Check if the cell at (x, y) in the map contains a wall

                    // Save the player's current position.
                    int position = map.getPixel(x, y);

                    // Rough color values for the wall boundary.
                    int pixelRed = Color.red(position);
                    int pixelGreen = Color.green(position);
                    int pixelBlue = Color.blue(position);

                    // Check if the colors of the position match that of the wall.
                    boolean redTrue = (pixelRed >= 10) || (pixelRed <= 30); //TRUE RED: 23
                    boolean blueTrue = (pixelBlue >= 10) || (pixelBlue <= 30); //TRUE BLUE: 23
                    boolean greenTrue = (pixelGreen >= 0) || (pixelGreen <= 30); //TRUE GREEN: 14

                    // If the colors match, there is a collision.
                    if (redTrue && blueTrue && greenTrue) {
                        return true; // Player is touching the wall
                    }
                }
            }
        }
        return false;
    }
}
