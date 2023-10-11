package com.example.cs2340a_team11.Environment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public interface BitmapInterface {
    // DO NOT CHANGE PIX_SIZE SINCE IT IS THE ORIGINAL SIZE FROM THE TILESET
    public static final int PIX_SIZE = 16;
    public static final int SCALE_FACTOR = 10;
    public static int TILE_SIZE = PIX_SIZE * SCALE_FACTOR;
    BitmapFactory.Options options = new BitmapFactory.Options();

    // scale the size of the map
    default Bitmap getScaledBitmap(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap,
                bitmap.getWidth() * SCALE_FACTOR,
                bitmap.getHeight() * SCALE_FACTOR,
                false);
    }
}
