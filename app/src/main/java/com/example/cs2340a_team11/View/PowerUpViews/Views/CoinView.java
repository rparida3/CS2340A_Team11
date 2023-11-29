package com.example.cs2340a_team11.View.PowerUpViews.Views;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.View.PowerUpViews.Sprites.CoinSprite;

public class CoinView extends View {
    private float x;
    private float y;
    private CoinSprite coinSprite;
    public CoinView(Context context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
        coinSprite = new CoinSprite(getResources());
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(coinSprite.getSprite(), x, y, null);
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
