package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.View.Characters.BanditSprite;

public class BanditView extends View {
    private float x;
    private float y;

    private int move = 0;
    private BanditSprite banditSprite;
    private Bandit bandit;


    public BanditView(Context context, float x, float y, Bandit bandit) {
        super(context);
        this.x = x;
        this.y = y;
        banditSprite = new BanditSprite(getResources());
        this.bandit = bandit;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(banditSprite.getSprite(), x, y, null);
    }

    public void updatePosition(float newX, float newY) {
        x = newX;
        y = newY;
        invalidate();
    }

    public void updatePosition() {
        if (move >= 16) {
            move = 0;
        }
        if (move < 4) {
            x += 160;
        } else if (move < 8) {
            y += 160;
        } else if (move < 12) {
            x -= 160;
        } else if (move < 16) {
            y -= 160;
        }
        move++;
        bandit.setX(x);
        bandit.setY(y);
        invalidate();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public Bandit getBandit() {
        return this.bandit;
    }

}
