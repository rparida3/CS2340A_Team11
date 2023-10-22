package com.example.cs2340a_team11.Environment;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.cs2340a_team11.Model.Wall;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CreatedMap {
    private int[][] spriteIds;
    private Wall walls = Wall.getWall();
    public CreatedMap(int[][] spriteIds) {
        this.spriteIds = spriteIds;
    }

    // loops through mapArray in MapView and assigns sprites
    public void draw(Canvas c) {
        System.out.println("Created Map being drawn");
        // walls.resetWalls();

        for (int j = 0; j < spriteIds.length; j++) {
            for (int i = 0; i < spriteIds[j].length; i++) {
                // check if wall, then store rect hitbox
                int currSprite = spriteIds[j][i];
                if (IntStream.of(BitmapInterface.COLLISIONS).anyMatch(n -> n == currSprite)) {
                    // note: i and j are swapped bc 2D-arrays weird (col/rows swapped in loop)
                    Rect wall = new Rect(i * 160, j * 160, (i + 1) * 160, (j + 1) * 160);
                    if (j == 0 && i == 0) {
                        System.out.println("[[CreatedMap]] First corner " + wall);
                    }
                    // System.out.println("Created map draw(): " + wall);
                    walls.addWall(wall);
                }

                if (currSprite < 0) {
                    continue; // if negative, do not draw
                } else {
                    c.drawBitmap(Background.FLOOR.getSprite(spriteIds[j][i]),
                            i * BitmapInterface.TILE_SIZE,
                            j * BitmapInterface.TILE_SIZE,
                            null);
                }
            }
        }
    }
}
