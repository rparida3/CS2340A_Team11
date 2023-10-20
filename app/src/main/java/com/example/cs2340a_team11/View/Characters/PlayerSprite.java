package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.cs2340a_team11.R;

public class PlayerSprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private Bitmap sprite;

    public PlayerSprite(Resources res, int charId) {
        if (charId == R.id.wizardButton) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.wizard);
        } else if (charId == R.id.knightButton) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.knight);
        } else {
            sprite = BitmapFactory.decodeResource(res, R.drawable.samurai);
        }

        width = 160;
        height = 160;

        // create variables for scaling if needed


        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);

        // x and y for now do nothing, but can use them to get location later
        x = 264;
        y = 264;

    }

    public Bitmap getSprite() {
        return sprite;
    }
}
