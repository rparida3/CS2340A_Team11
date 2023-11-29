package com.example.cs2340a_team11.View.PowerUpViews.Sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class PowerUpSprite {
    private int width;
    private int height;

    private int id;

    private Bitmap sprite;

    public PowerUpSprite (Resources resource, int id) {
        sprite = BitmapFactory.decodeResource(resource, id);
        width = 80;
        height = 80;
        this.id = id;
        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);
    }

    public Bitmap getSprite() {
        return sprite;
    }
    public void setWidth(int width) {
        this.width = width;
        sprite = Bitmap.createScaledBitmap(sprite, this.width, height, false);
    }
    public void setHeight(int height) {
        this.height = height;
        sprite = Bitmap.createScaledBitmap(sprite, this.width, this.height, false);
    }

}
