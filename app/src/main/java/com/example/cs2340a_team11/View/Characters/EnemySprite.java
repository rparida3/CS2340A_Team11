package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class EnemySprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Bitmap sprite;

    public EnemySprite(Resources res, String charId) {
        if (charId.equalsIgnoreCase("skeleton")) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.skeletonenemyidle);
        } else if (charId.equalsIgnoreCase("evilWizard")) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.evilwizardidle);
        } else if (charId.equalsIgnoreCase("bandit")) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.heavybanditidle);
        } else if (charId.equalsIgnoreCase("night")) {
            sprite = BitmapFactory.decodeResource(res, R.drawable.nightborneidle);
        }

        width = 160;
        height = 160;
        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);
    }
}
