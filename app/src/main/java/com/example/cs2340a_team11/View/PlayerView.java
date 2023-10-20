package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.cs2340a_team11.R;

public class PlayerView extends View {
    private float x, y; // change to float in player????
    private int charId;
    private Drawable character;


    public PlayerView(Context context, float x, float y, int charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        character = ContextCompat.getDrawable(context, R.drawable.wizard);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        character.setBounds(16, 16, 16, 16);
        character.draw(canvas);
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
