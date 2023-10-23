package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.PlayerSprite;

public class PlayerView extends View {
    private float x;
    private float y;
    private PlayerSprite playerSprite;
    private int charId;

    public PlayerView(Context context, float x, float y, int charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        playerSprite = new PlayerSprite(getResources(), charId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.print("onDraw [[PlayerView]]... ");
        super.onDraw(canvas);

        canvas.drawBitmap(playerSprite.getSprite(), x, y, null);
    }

    public void updatePosition(float newX, float newY) {
        x = newX;
        y = newY;
        invalidate();
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
