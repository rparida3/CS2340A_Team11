package com.example.cs2340a_team11.Environment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.GameScreenActivity;
import com.example.cs2340a_team11.View.MapOneActivity;

public enum Background implements BitmapInterface {
    // reference the tileset spritesheet and its dimensions
    FLOOR(R.drawable.dungeon_tileset, 10, 10);

    private Bitmap[] sprites;

    Background(int resID, int tilesInWidth, int tilesInHeight) {
        options.inScaled = false;
        sprites = new Bitmap[tilesInHeight * tilesInWidth];

        // find a way to deal with getGameContext()
        Bitmap spriteSheet = BitmapFactory.decodeResource(
                MapOneActivity.getGameContext().getResources(), resID, options);

        // generates the map
        for (int j = 0; j < tilesInHeight; j++) {
            for (int i = 0; i < tilesInWidth; i++) {
                int index = j * tilesInWidth + i;

                sprites[index] = getScaledBitmap(Bitmap.createBitmap(spriteSheet,
                        PIX_SIZE * i,
                        PIX_SIZE * j,
                        PIX_SIZE,
                        PIX_SIZE));
            }
        }
    }

    public Bitmap getSprite(int id) {
        // Note: id is also the index of the sprites
        return sprites[id];
    }

}
