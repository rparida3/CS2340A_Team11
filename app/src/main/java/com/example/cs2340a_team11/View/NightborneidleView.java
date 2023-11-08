package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.NightborneidleSprite;
import com.example.cs2340a_team11.View.Characters.SkeletonSprite;

public class NightborneidleView extends View {
    private float x;
    private float y;
    private NightborneidleSprite nbSprite;
    private int move = 0;

    public NightborneidleView(Context context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
        nbSprite = new NightborneidleSprite(getResources());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(nbSprite.getSprite(), x, y, null);
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
        invalidate();
    }
    /*
    public void runMovement() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            updatePosition(getX() + 160, getY());
        }
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            updatePosition(getX(), getY() + 160);
        }
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            updatePosition(getX() - 160, getY());
        }
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            updatePosition(getX(), getY() - 160);
        }
    }
    */

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
