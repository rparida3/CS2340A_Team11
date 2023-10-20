package com.example.cs2340a_team11.View.Characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.cs2340a_team11.R;

public class Wizard {
    private int x, y, width, height;
    private Bitmap wizard;

    public Wizard(Resources res) {
        wizard = BitmapFactory.decodeResource(res, R.drawable.wizard);

        width = wizard.getWidth() / 2;
        height = wizard.getHeight() / 2;

        // create variables for scaling if needed


        wizard = Bitmap.createScaledBitmap(wizard, 160, 160, false);

        // x and y for now do nothing, but can use them to get location later
        x = 264;
        y = 264;
    }

    public Bitmap getWizard() {
        return wizard;
    }
}
