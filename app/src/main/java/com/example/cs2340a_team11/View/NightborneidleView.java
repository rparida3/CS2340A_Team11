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

    @Deprecated
    public void updatePosition(float newX, float newY) {
        x = newX;
        y = newY;
        invalidate();
    }

    public void updatePosition() {
        if (move >= 9) {
            move = 0;
        }
        if (move < 3) {
            x += 160;
        } else if (move < 5) {
            y += 160;
        } else if (move < 7) {
            x -= 160;
        } else if (move < 9) {
            y -= 160;
        }
        move++;
        invalidate();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
