package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class NightborneidleSprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private Bitmap sprite;

    public NightborneidleSprite(Resources res) {
        sprite = BitmapFactory.decodeResource(res, R.drawable.nightborneidle);
        width = 160;
        height = 160;
        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);
    }

    public Bitmap getSprite() {
        return sprite;
    }
}
