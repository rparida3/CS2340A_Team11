package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;
import com.example.cs2340a_team11.Model.Player;
import org.junit.Test;

public class MovementTests {
    @Test
    public void testMoveLeft() {
        Player.getPlayer().setX(500);
        Player.getPlayer().setY(500);
        assertEquals(Player.getPlayer().getX(), 500, 0);
        assertEquals(Player.getPlayer().getY(), 500, 0);

        Player.getPlayer().moveLeft();

        assertEquals(Player.getPlayer().getX(), 340, 0); // 340 = 500 - 160
        assertEquals(Player.getPlayer().getY(), 500, 0); // y-coord stays the same

    }


    @Test
    public void testMoveRight() {
        Player.getPlayer().setX(300);
        Player.getPlayer().setY(500);
        assertEquals(Player.getPlayer().getX(), 300, 0);
        assertEquals(Player.getPlayer().getY(), 500, 0);

        Player.getPlayer().moveRight();

        assertEquals(Player.getPlayer().getX(), 460, 0); // 460 = 300 + 160
        assertEquals(Player.getPlayer().getY(), 500, 0); // y-coord stays the same
    }


}