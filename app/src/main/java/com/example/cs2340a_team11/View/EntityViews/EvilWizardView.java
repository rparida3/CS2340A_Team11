package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;

public class EvilWizardView extends EnemyView {

    private int move = 0;
    private EvilWizard evilWizard;
    private String dir = "D";

    public EvilWizardView(Context context, float x, float y, EvilWizard evilWizard) {
        super(context, x, y, "evilwizard");
        this.evilWizard = evilWizard;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(enemySprite.getSprite(), x, y, null);
        //Paint paint = new Paint();
        //paint.setColor(Color.GREEN);
        //canvas.drawRect(evilWizard.getX(), evilWizard.getY(),
        // evilWizard.getX() + 160, evilWizard.getY() + 160, paint);
    }

    public void updatePosition(float newX, float newY) {
        if (move < 3) {
            dir = "D";
        } else if (move < 5) {
            dir = "U";
        } else {
            move = 0;
            dir = "D";
        }
        move++;
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

    public String getDir() {
        return dir;
    }
    public EvilWizard getEvilWizard() {
        return this.evilWizard;
    }


}
