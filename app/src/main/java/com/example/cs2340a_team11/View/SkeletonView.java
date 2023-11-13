package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Model.Nightborneidle;
import com.example.cs2340a_team11.Model.Skeleton;
import com.example.cs2340a_team11.View.Characters.SkeletonSprite;

public class SkeletonView extends View {
    private float x;
    private float y;

    private int move = 0;
    private SkeletonSprite skeletonSprite;
    private Skeleton skeleton;


    public SkeletonView(Context context, float x, float y, Skeleton skeleton) {
        super(context);
        this.x = x;
        this.y = y;
        skeletonSprite = new SkeletonSprite(getResources());
        this.skeleton = skeleton;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(skeletonSprite.getSprite(), x, y, null);
    }

    public void updatePosition() {
        if (move < 5) {
            x += 160;
        } else if (move >= 5 && move < 9) {
            x -= 160;
        } else {
            move = 0;
        }
        move++;
        skeleton.setX(x);
        skeleton.setY(y);
        invalidate();
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public Skeleton getSkeleton() {
        return this.skeleton;
    }
}
