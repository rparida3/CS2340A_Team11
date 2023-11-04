package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.EvilWizardSprite;


public class EvilWizardView extends View {
    private float x;
    private float y;
    private EvilWizardSprite evilWizardSprite;
    private int charId;

    public EvilWizardView(Context context, float x, float y, int charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        evilWizardSprite = new EvilWizardSprite(getResources());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(evilWizardSprite.getSprite(), x, y, null);
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
