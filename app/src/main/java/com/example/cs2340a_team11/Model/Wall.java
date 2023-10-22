package com.example.cs2340a_team11.Model;

import android.graphics.Rect;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Wall {
    private static Wall wall;

    private boolean isDrawn = false;
    private ArrayList<Rect> walls;
    private ArrayList<Rect> doors;

    private Wall() {
        walls = new ArrayList<Rect>();
        doors = new ArrayList<Rect>();
    }

    public static Wall getWall() {
        if (wall == null) {
            wall = new Wall();
        }
        return wall;
    }

    public void addWall(Rect wall) {
        walls.add(wall);
    }

    public void addDoor(Rect door) { doors.add(door); }
    public ArrayList<Rect> getWalls() {
        return walls;
    }
    public ArrayList<Rect> getDoors() { return doors; }
    public void resetWalls() {
        walls = new ArrayList<>();
        doors = new ArrayList<>();
    }

    public void setIsDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }

    public boolean getIsDrawn() {
        return this.isDrawn;
    }
}