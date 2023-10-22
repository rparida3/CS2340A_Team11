package com.example.cs2340a_team11;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;

import com.example.cs2340a_team11.ViewModel.EndScreenViewModel;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;
import com.example.cs2340a_team11.ViewModel.InitialConfigViewModel;
public class Sprint3_JunitTests {
    @Test
    public void checkMovementLogic() {
        Player player = Player.getPlayer();
        float[] playerMovement = new float[2];
        player.moveRight();
        for (int i = 0; i < 4; i++) {
            player.moveDown();
        }
        playerMovement[0] = player.getX();
        playerMovement[1] = player.getY();
        assertArrayEquals(new float[] {160, 640}, playerMovement, 0);
        player.setX(0);
        for (int i = 0; i < 5; i++) {
            player.moveLeft();
            player.moveUp();
        }
        playerMovement[0] = player.getX();
        playerMovement[1] = player.getY();
        assertArrayEquals(new float[] {-800, -160}, playerMovement, 0);
        player.setX(0);
        player.setY(0);
        for (int i = 0; i < 10; i++) {
            player.moveLeft();
            player.moveRight();
            player.moveDown();
            player.moveUp();
        }
        playerMovement = new float[] {player.getX(), player.getY()};
        assertArrayEquals(new float[] {0, 0}, playerMovement, 0);
    }

    @Test
    public void startingMapCheckDoorTest() {
        GameScreenViewModel gameScreenViewModel = new GameScreenViewModel();
        Player player = Player.getPlayer();
        gameScreenViewModel.setPlayerStarting(2);
        assertEquals(6 * BitmapInterface.TILE_SIZE + 320, player.getY(), 0);
        assertEquals(BitmapInterface.TILE_SIZE, player.getX(), 0);
        assertFalse(gameScreenViewModel.checkDoor());
        player.setX(160);
        player.setY(480);
        assertTrue(gameScreenViewModel.checkDoor());
    }
}
