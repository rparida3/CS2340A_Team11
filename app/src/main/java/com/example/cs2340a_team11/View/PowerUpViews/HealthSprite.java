package com.example.cs2340a_team11.View.PowerUpViews;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class HealthSprite {

   private int width;
   private int height;
   private Bitmap sprite;

   public HealthSprite(Resources resource) {
       sprite = BitmapFactory.decodeResource(resource, R.drawable.heart_sprite);
       width = 80;
       height = 80;
       sprite = Bitmap.createScaledBitmap(sprite, width, height, false);
   }

   public Bitmap getSprite() {
       return sprite;
   }

}
