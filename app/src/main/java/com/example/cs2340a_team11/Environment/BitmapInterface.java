package com.example.cs2340a_team11.Environment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public interface BitmapInterface {
    public static final int pixSize = 16;
    public static final int scaleFactor = 10;
    public static int tileSize = pixSize * scaleFactor;
    BitmapFactory.Options options = new BitmapFactory.Options();

    // scale the size of the map
    default Bitmap getScaledBitmap(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * scaleFactor, bitmap.getHeight() * scaleFactor, false);
    }
}
