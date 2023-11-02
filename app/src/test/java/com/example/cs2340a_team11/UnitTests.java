package com.example.cs2340a_team11;


import org.junit.Test;

import static org.junit.Assert.*;






import com.example.cs2340a_team11.Model.Player;

import com.example.cs2340a_team11.ViewModel.EndScreenViewModel;
import com.example.cs2340a_team11.ViewModel.InitialConfigViewModel;




public class UnitTests {
    @Test
    public void blankNameReturnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName(""));
    }

    @Test
    public void whitespaceNameReturnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName("   "));
    }

    @Test
    public void nullNameReturnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName(null));
    }

    @Test
    public void restartResetsScore() {
        // Tests if resetScore() method used in restart buttons works or not
        Player player = Player.getPlayer();
        EndScreenViewModel end = new EndScreenViewModel();

        // Positive Score
        player.setScore(50);
        end.resetScore();
        assertEquals(0, player.getScore());

        // Negative Score
        player.setScore(-30);
        end.resetScore();
        assertEquals(0, player.getScore());
    }

    @Test
    public void healthBasedOnDifficultyAndChar() {
        Player player = Player.getPlayer();
        int wizId = R.id.wizardButton;
        int assassinId = R.id.assassinButton;
        int knightId = R.id.knightButton;

        //Easy
        player.setDifficulty("Easy");

        player.setCharId(wizId);
        assertEquals(30, player.getHP());

        player.setCharId(assassinId);
        assertEquals(20, player.getHP());

        player.setCharId(knightId);
        assertEquals(50, player.getHP());

        //Medium
        double med = 0.8;
        player.setDifficulty("Medium");
        player.setCharId(wizId);
        assertEquals(med * 30, player.getHP(), 0.0);

        player.setCharId(assassinId);
        assertEquals(med * 20, player.getHP(), 0.0);

        player.setCharId(knightId);
        assertEquals(med * 50, player.getHP(), 0.0);

        //Hard
        double hard = 0.6;
        player.setDifficulty("Hard");

        player.setCharId(wizId);
        assertEquals(hard * 30, player.getHP(), 0.0);

        player.setCharId(assassinId);
        assertEquals(hard * 20, player.getHP(), 0.0);

        player.setCharId(knightId);
        assertEquals(hard * 50, player.getHP(), 0.0);
    }
    @Test
    public void validNameReturnsTrue() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertTrue(sample.checkName("John"));
    }
    @Test
    public void validNameWithSpacesReturnsTrue() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertTrue(sample.checkName("Alice Johnson"));
    }
    @Test
    public void testInitialPosition() {
        assertEquals(0.0f, Player.getPlayer().getX(), 0.01);
        assertEquals(0.0f, Player.getPlayer().getY(), 0.01);
    }
    @Test
    public void testMoveUp() {
        float initialY = Player.getPlayer().getY();
        Player.getPlayer().moveUp();
        assertEquals(initialY - 160, Player.getPlayer().getY(), 0.01);
    }
}
