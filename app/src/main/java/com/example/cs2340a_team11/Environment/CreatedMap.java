package com.example.cs2340a_team11.Environment;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CreatedMap {
    private int[][] spriteIds;

    private ArrayList<Rect> walls = new ArrayList<Rect>();
    public CreatedMap(int[][] spriteIds) {
        this.spriteIds = spriteIds;
    }

    // loops through mapArray in MapView and assigns sprites
    public ArrayList<Rect> draw(Canvas c) {
        for (int j = 0; j < spriteIds.length; j++) {
            for (int i = 0; i < spriteIds[j].length; i++) {
                // check if wall, then store coords
                int currSprite = spriteIds[j][i];
                if (IntStream.of(BitmapInterface.COLLISIONS).anyMatch(n -> n == currSprite)) {
                    // note: i and j are swapped bc 2D-arrays weird
                    Rect wall = new Rect(i * 160, j * 160, (i + 1) * 160, (j + 1) * 160);
                    System.out.println(wall);
                    walls.add(wall);
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
        return walls;
    }
}
