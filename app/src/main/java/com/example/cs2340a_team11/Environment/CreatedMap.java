package com.example.cs2340a_team11.Environment;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CreatedMap {
    private int[][] spriteIds;

    public CreatedMap(int[][] spriteIds) {
        this.spriteIds = spriteIds;
    }

    // loops through mapArray in MapView and assigns sprites
    public void draw(Canvas c) {
        for (int j = 0; j < spriteIds.length; j++) {
            for (int i = 0; i < spriteIds[j].length; i++) {
                // check if wall, then store coords
                int currSprite = spriteIds[j][i];

                //if (Arrays.asList(BitmapInterface.COLLISIONS).contains(currSprite)) {
                if (IntStream.of(BitmapInterface.COLLISIONS).anyMatch(n -> n == currSprite)) {
                    Rect wall = new Rect(j * 160, i * 160, (j + 1) * 160, (i + 1) * 160);
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
