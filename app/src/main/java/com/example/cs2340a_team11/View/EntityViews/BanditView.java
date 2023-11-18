package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.View.Characters.BanditSprite;

public class BanditView extends EnemyView {
    private String dir = "R";
    private int move = 0;
    // private BanditSprite banditSprite;
    private Bandit bandit;

    public BanditView(Context context, float x, float y, Bandit bandit) {
        super(context, x, y, "bandit");
        //this.x = x;
        //this.y = y;
        //banditSprite = new BanditSprite(getResources());
        this.bandit = bandit;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Paint paint = new Paint();
        // paint.setColor(Color.GREEN);
        super.onDraw(canvas);
        canvas.drawBitmap(enemySprite.getSprite(), x, y, null);
        // canvas.drawRect(bandit.getX(), bandit.getY(), bandit.getX() + 160, bandit.getY() + 160, null);
    }

    public void updatePosition(float newX, float newY) {
        if (move >= 16) {
            move = 0;
            dir = "R";
        }
        if (move < 3) {
            dir = "R";
        } else if (move < 8) {
            dir = "D";
        } else if (move < 13) {
            dir = "L";
        } else if (move < 16) {
            dir = "U";
        }
        move++;
        x = newX;
        y = newY;
        invalidate();
    }

    public void updatePosition() {
        if (move >= 16) {
            move = 0;
            dir = "R";
        }
        if (move < 4) {
            x += 160;
            dir = "R";
        } else if (move < 8) {
            y += 160;
            dir = "D";
        } else if (move < 12) {
            x -= 160;
            dir = "L";
        } else if (move < 16) {
            y -= 160;
            dir = "U";
        }
        move++;
        bandit.setX(x);
        bandit.setY(y);
        invalidate();
    }

    public String getDir() {
        return dir;
    }

    public Bandit getBandit() {
        return this.bandit;
    }
}
