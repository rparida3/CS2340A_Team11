package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.View.Activities.PauseScreen;
import com.example.cs2340a_team11.View.Maps.MapFinalActivity;
import com.example.cs2340a_team11.View.Maps.MapOneActivity;
import com.example.cs2340a_team11.View.Maps.MapTwoActivity;

import org.junit.Test;

public class PauseMenuJUnits {
    @Test
    public void checkScorePause() {
        MapTwoActivity map = new MapTwoActivity();
        PauseScreen pause = new PauseScreen();
        Player player = Player.getPlayer();
        // Move player to change score
        player.moveUp();

        // Get score
        int initialScore = player.getScore();

        // Pause game
        map.moveToPauseScreen();

        // Resume game
        pause.resumeGame();

        // Check that score remains unchanged
        assertEquals(player.getScore(), initialScore);
    }

    public void checkMapSet() {
        // Create map, pause object
        MapOneActivity map = new MapOneActivity();
        MapTwoActivity map2 = new MapTwoActivity();
        MapFinalActivity map3 = new MapFinalActivity();
        PauseScreen pause = new PauseScreen();

        // Pause game
        map.moveToPauseScreen();

        // Resume game
        pause.resumeGame();

        assertEquals(map.getClass().getName(), "MapOneActivity");

        // Pause game
        map2.moveToPauseScreen();

        // Resume game
        pause.resumeGame();

        assertEquals(map2.getClass().getName(), "MapTwoActivity");

        // Pause game
        map3.moveToPauseScreen();

        // Resume game
        pause.resumeGame();

        assertEquals(map3.getClass().getName(), "MapFinalActivity");


    }
}
