package com.example.cs2340a_team11.View.PowerUpViews.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Model.PowerUpModels.Invincibility;
import com.example.cs2340a_team11.View.PowerUpViews.Sprites.InvincibilitySprite;

public class InvincibilityView extends View {
    private float x;
    private float y;
    private InvincibilitySprite invincibilitySprite;
    private Invincibility invincibility;
    private int move = 0;

    public InvincibilityView(Context context, float x, float y, Invincibility invincibility) {
        super(context);
        this.x = x;
        this.y = y;
        this.invincibility = invincibility;
        invincibilitySprite = new InvincibilitySprite(getResources());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(invincibilitySprite.getSprite(), x, y, null);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public Invincibility getHeart() {
        return this.invincibility;
    }
}
