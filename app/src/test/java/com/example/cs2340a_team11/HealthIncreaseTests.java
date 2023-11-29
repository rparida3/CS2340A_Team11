package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.view.View;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.PowerUpModels.HealthIncrease;
import com.example.cs2340a_team11.Model.PowerUpModels.Invincibility;
import com.example.cs2340a_team11.View.Maps.MapTwoActivity;
import com.example.cs2340a_team11.View.PowerUpViews.Views.HealthIncreaseView;

import org.junit.Test;

public class HealthIncreaseTests {

    @Test
    public void testHealthIncrease() {
        Player player = Player.getPlayer();
        HealthIncrease healthIncrease = new HealthIncrease();
        healthIncrease.powerUpAbility();
        assertEquals(player.getInitialHP() + 10, player.getHP());
    }

    @Test
    public void testHealthViewDisappear() {
        Player player = Player.getPlayer();
        HealthIncrease healthIncrease = new HealthIncrease();
        assertEquals(player.getInitialHP(), player.getHP());
    }
}
