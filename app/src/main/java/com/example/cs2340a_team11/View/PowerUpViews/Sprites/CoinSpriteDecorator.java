package com.example.cs2340a_team11.View.PowerUpViews.Sprites;

import android.content.res.Resources;

import com.example.cs2340a_team11.R;

public class CoinSpriteDecorator extends PowerUpSpriteDecorator {
    public CoinSpriteDecorator(Resources resource) {
        super(resource, R.drawable.coin);
        this.setWidth(160);
        this.setHeight(160);
    }
}
