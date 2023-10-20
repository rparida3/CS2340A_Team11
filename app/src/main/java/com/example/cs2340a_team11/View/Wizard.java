package com.example.cs2340a_team11.View;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cs2340a_team11.R;

public class Wizard {
    int x, y, width, height;
    Bitmap wizard;

    Wizard (Resources res) {
        wizard = BitmapFactory.decodeResource(res, R.drawable.wizard);

        width = wizard.getWidth() / 2;
        height = wizard.getHeight() / 2;

        // create variables for scaling


        wizard = Bitmap.createScaledBitmap(wizard, width, height, false);
        x = 128;
        y = 128;
    }

    Bitmap getWizard() {
        return wizard;
    }
}
