package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.View.Characters.NightborneidleSprite;

public class NightborneidleView extends EnemyView {
    private NightborneidleSprite nbSprite;
    private Nightborneidle nightborne;
    private String dir = "D";
    private int move = 0;

    public NightborneidleView(Context context, float x, float y, Nightborneidle nightborne) {
        super(context, x, y, "night");
        this.nightborne = nightborne;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(enemySprite.getSprite(), x, y, null);
    }

    @Deprecated
    public void updatePosition(float newX, float newY) {
        if (move >= 9) {
            move = 1;
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
        x = newX;
        y = newY;
        invalidate();
    }

    public Nightborneidle getNightborne() {
        return this.nightborne;
    }
}
