package com.example.cs2340a_team11.Environment;

import android.graphics.Canvas;

public class createdMap {
    private int[][] spriteIds;

    public createdMap(int[][] spriteIds) {
        this.spriteIds = spriteIds;
    }

    // loops through mapArray in MapView and assigns sprites
    public void draw(Canvas c) {
        for (int j = 0; j < spriteIds.length; j++) {
            for (int i = 0; i < spriteIds[j].length; i++) {
                if (spriteIds[j][i] < 0) {
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
