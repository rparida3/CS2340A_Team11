package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;
import com.example.cs2340a_team11.Model.Player;
import org.junit.Test;

public class AssassinCharacterTests {

    @Test
    public void testAssassinMovement() {
        Player.getPlayer().setDifficulty("Easy");
        Player.getPlayer().setCharId(R.id.assassinButton);
        assertEquals(Player.getPlayer().getMovement(), 10, 0.0);

        Player.getPlayer().setDifficulty("Hard");
        assertEquals(Player.getPlayer().getMovement(), 6, 0);
    }

    @Test
    public void testAssassinHP() {
        Player.getPlayer().setCharId(R.id.assassinButton);
        assertEquals(Player.getPlayer().getHP(), 20, 0);

        Player.getPlayer().setDifficulty("Medium");
        assertEquals(Player.getPlayer().getHP(), 16, 0.0);
    }
}
