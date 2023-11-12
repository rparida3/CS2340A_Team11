package com.example.cs2340a_team11.View;

import android.content.Context;
import android.view.View;

import com.example.cs2340a_team11.View.Characters.PlayerSprite;
import com.example.cs2340a_team11.View.Characters.EnemySprite;

public class EnemyView extends View {
    private float x;
    private float y;
    private EnemySprite enemySprite;
    private String charId;

    public EnemyView(Context context, float x, float y, String charId) {
        super(context);
        this.x = x;
        this.y = y;
        this.charId = charId;
        enemySprite = new EnemySprite(getResources(), charId);
    }

}
