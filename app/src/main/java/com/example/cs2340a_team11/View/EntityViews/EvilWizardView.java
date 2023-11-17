package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Model.EvilWizard;
import com.example.cs2340a_team11.View.Characters.EvilWizardSprite;


public class EvilWizardView extends View {
    private float x;
    private float y;

    private int move = 0;
    private EvilWizardSprite evilWizardSprite;
    private EvilWizard evilWizard;

    public EvilWizardView(Context context, float x, float y, EvilWizard evilWizard) {
        super(context);
        this.x = x;
        this.y = y;
        evilWizardSprite = new EvilWizardSprite(getResources());
        this.evilWizard = evilWizard;
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

    public void updatePosition() {
        if (move < 3) {
            y += 160;
        } else if (move < 5) {
            y -= 160;
        } else {
            move = 0;
        }
        move++;
        evilWizard.setX(x);
        evilWizard.setY(y);
        invalidate();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public EvilWizard getEvilWizard() {
        return this.evilWizard;
    }
}
