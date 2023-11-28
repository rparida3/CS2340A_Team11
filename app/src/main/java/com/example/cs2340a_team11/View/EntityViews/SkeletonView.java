package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;

import com.example.cs2340a_team11.Model.Enemies.Skeleton;

public class SkeletonView extends EnemyView {
    private String dir = "R";
    private int move = 0;
    private Skeleton skeleton;


    public SkeletonView(Context context, float x, float y, Skeleton skeleton) {
        super(context, x, y, "skeleton");
        this.skeleton = skeleton;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(enemySprite.getSprite(), x, y, null);
    }

    public void updatePosition(float newX, float newY) {
        if (move < 5) {
            dir = "R";
        } else if (move >= 5 && move < 9) {
            dir = "L";
        } else {
            move = 0;
        }
        move++;
        x = newX;
        y = newY;
        invalidate();
    }

    public Skeleton getSkeleton() {
        return this.skeleton;
    }
}
