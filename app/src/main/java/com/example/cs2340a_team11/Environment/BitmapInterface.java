package com.example.cs2340a_team11.Environment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public interface BitmapInterface {
    BitmapFactory.Options options = new BitmapFactory.Options();
    default Bitmap getScaledBitmap(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 6, bitmap.getHeight() * 6, false);
    }
}
