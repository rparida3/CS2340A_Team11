package com.example.cs2340a_team11.View.PowerUpViews.Sprites;

import android.content.res.Resources;

import com.example.cs2340a_team11.Model.PowerUpModels.PowerUp;
import com.example.cs2340a_team11.R;


public class InvincibilitySprite extends PowerUpSpriteDecorator {
    public InvincibilitySprite(Resources resource) {
        super(resource, R.drawable.invincibility);
    }
}
