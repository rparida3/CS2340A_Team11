package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.cs2340a_team11.R;

public class PlayerSprite {
    private int x, y, width, height;
    private Bitmap sprite;

    public PlayerSprite(Resources res, int charId) {
        if (charId == R.id.wizardButton) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.wizard);
        } else if (charId == R.id.knightButton) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.knight);
        } else {
            sprite = BitmapFactory.decodeResource(res, R.drawable.samurai);
        }

        width = sprite.getWidth() / 2;
        height = sprite.getHeight() / 2;

        // create variables for scaling if needed


        sprite = Bitmap.createScaledBitmap(sprite, 160, 160, false);

        // x and y for now do nothing, but can use them to get location later
        x = 264;
        y = 264;
    }

    public Bitmap getSprite() {
        return sprite;
    }
}
