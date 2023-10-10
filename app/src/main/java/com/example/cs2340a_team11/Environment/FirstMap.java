package com.example.cs2340a_team11.Environment;

import android.graphics.Canvas;

public class FirstMap {
    private int[][] spriteIds;

    public FirstMap(int[][] spriteIds) {
        this.spriteIds = spriteIds;
    }

    public void draw(Canvas c) {
        for (int j = 0; j < spriteIds.length; j++) {
            for (int i = 0; i < spriteIds[j].length; i++) {
                c.drawBitmap(Background.FLOOR.getSprite(spriteIds[j][i]), i * 96, j * 96, null);
            }
        }
    }
}
