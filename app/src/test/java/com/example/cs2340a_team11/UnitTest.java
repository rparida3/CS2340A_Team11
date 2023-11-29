package com.example.cs2340a_team11;


import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340a_team11.Model.Player;


public class UnitTest {

    @Test
    public void testInitialHPForWizard() {
        Player player = Player.getPlayer();
        player.setCharId(R.id.wizardButton);

        assertEquals(30, player.getInitialHP(), 0);

    }

    @Test
    public void testInitialHPForAssassin() {
        Player player = Player.getPlayer();
        player.setCharId(R.id.assassinButton);

        assertEquals(20, player.getInitialHP(), 0);
    }


}
