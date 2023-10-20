package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.Wizard;

public class PlayerView extends View {
    private float x, y;
    private Wizard wizard;
    private int charId;


    public PlayerView(Context context, float x, float y, int charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        wizard = new Wizard(getResources());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // DO PLEASE: refactor to take in different selections of character, in a viewmodel
        canvas.drawBitmap(wizard.getWizard(), x, y, null);
    }

    public void updatePosition(float newX, float newY) {
        x = newX;
        y = newY;
        invalidate();   // ???????
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
