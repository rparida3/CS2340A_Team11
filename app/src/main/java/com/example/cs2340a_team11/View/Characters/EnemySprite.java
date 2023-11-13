package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.Model.Enemy;

public class EnemySprite {

    private int x;
    private int y;
    private int width;
    private int height;
    private Bitmap sprite;

    public EnemySprite(Resources res, String charId) {

        // 0 = Bandit, 1 = EvilWizard,
        // 2 = Nightborneidle, 3 = Skeleton
        if (charId.equalsIgnoreCase("Skeleton")) {
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

        // create variables for scaling if needed


        sprite = Bitmap.createScaledBitmap(sprite, width, height, false);

        // x and y for now do nothing, but can use them to get location later
        // x = 264;
        // y = 264;

    }
}
