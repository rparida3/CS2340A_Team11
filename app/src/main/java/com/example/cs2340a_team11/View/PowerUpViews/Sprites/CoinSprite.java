package com.example.cs2340a_team11.View.PowerUpViews.Sprites;

import android.content.res.Resources;

import com.example.cs2340a_team11.R;

public class CoinSprite extends PowerUpSprite {
    public CoinSprite(Resources resource) {
        super(resource, R.drawable.coin);
        this.setWidth(160);
        this.setHeight(160);
    }
}
