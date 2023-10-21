package com.example.cs2340a_team11.Environment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public interface BitmapInterface {
    // DO NOT CHANGE PIX_SIZE SINCE IT IS THE ORIGINAL SIZE FROM THE TILESET
    public static final int PIX_SIZE = 16;
    public static final int SCALE_FACTOR = 10;
    public static int TILE_SIZE = PIX_SIZE * SCALE_FACTOR;
    BitmapFactory.Options OPTIONS = new BitmapFactory.Options();

    public static int[] COLLISIONS = {
        0, 1, 2, 3, 4, 5, 10, 20, 30, 15, 25, 35,
        40, 41, 42, 43, 44, 45, 50, 51, 52, 53, 54, 55
    };

    // scale the size of the map
    default Bitmap getScaledBitmap(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap,
                bitmap.getWidth() * SCALE_FACTOR,
                bitmap.getHeight() * SCALE_FACTOR,
                false);
    }
}
