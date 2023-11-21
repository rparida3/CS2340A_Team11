package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.View.Characters.PlayerSprite;

public class PlayerView extends View {
    private float x;
    private float y;
    private PlayerSprite playerSprite;
    private Player player = Player.getPlayer();
    private int charId;
    private boolean attacking = false;

    public PlayerView(Context context, float x, float y, int charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        playerSprite = new PlayerSprite(getResources(), charId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw [[PlayerView]]... ");
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAlpha(40);
        canvas.drawBitmap(playerSprite.getSprite(), x, y, null);
        if (attacking) {
            canvas.drawRect(player.getX() - 160,
                    player.getY() - 160,
                    player.getX() + 320,
                    player.getY() + 320, paint);
        }
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
    public void setAttacking(boolean val) {
        this.attacking = val;
    }
}
