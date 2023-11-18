package com.example.cs2340a_team11.View.EntityViews;

import android.content.Context;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.PlayerSprite;
import com.example.cs2340a_team11.View.Characters.EnemySprite;

public abstract class EnemyView extends View {
    protected float x;
    protected float y;
    protected EnemySprite enemySprite;
    protected String charId;

    public EnemyView(Context context, float x, float y, String charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        enemySprite = new EnemySprite(getResources(), charId);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
