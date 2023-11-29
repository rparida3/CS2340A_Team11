package com.example.cs2340a_team11.View;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class HealthBoostSprite {
    private int width;
    private int height;
    private Bitmap sprite;

    public HealthBoostSprite(Resources res) {
        sprite = BitmapFactory.decodeResource(res, R.drawable.health);
        width = 160;
        height = 160;
        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);
    }

    public Bitmap getSprite() {
        return sprite;
    }

}
