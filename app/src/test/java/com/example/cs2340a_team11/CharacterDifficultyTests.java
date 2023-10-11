package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a_team11.Model.Player;

import org.junit.Test;

public class CharacterDifficultyTests {
    @Test
    public void testCharacterIdHealth() {
        Player.getPlayer().setCharId(R.id.wizardButton);
        assertEquals(Player.getPlayer().getHP(), 30);
    }

    @Test
    public void testCharacterIdMovement() {
        Player.getPlayer().setCharId(R.id.wizardButton);
        assertEquals(Player.getPlayer().getMovement(),5.0, 0.0);
    }
}
