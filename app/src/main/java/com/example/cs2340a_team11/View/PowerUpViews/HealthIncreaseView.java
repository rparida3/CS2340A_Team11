package com.example.cs2340a_team11.View.PowerUpViews;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Model.Nightborneidle;
import com.example.cs2340a_team11.Model.PowerUpModels.HealthIncrease;
import com.example.cs2340a_team11.View.Characters.NightborneidleSprite;

public class HealthIncreaseView extends View {

        private float x;
        private float y;
        private HealthSprite healthSprite;
        private HealthIncrease healthIncrease;
        private int move = 0;

        public HealthIncreaseView(Context context, float x, float y, HealthIncrease healthIncrease) {
            super(context);
            this.x = x;
            this.y = y;
            this.healthIncrease = healthIncrease;
            healthSprite = new HealthSprite(getResources());
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(healthSprite.getSprite(), x, y, null);
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
        public HealthIncrease getHeart() {
            return this.healthIncrease;
        }
}


