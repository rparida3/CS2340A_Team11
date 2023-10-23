package com.example.cs2340a_team11;
import org.junit.Test;

import static org.junit.Assert.*;

import android.graphics.Rect;
import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;

import java.util.ArrayList;

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
    @Test
    public void testPlacement1X() {
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setCurrMap(1);
        testModel.setPlayerStarting(1);
        assertEquals(Player.getPlayer().getX(),3 * BitmapInterface.TILE_SIZE, 0);
    }
    @Test
    public void testPlacement1Y() {
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setCurrMap(1);
        testModel.setPlayerStarting(1);
        assertEquals(Player.getPlayer().getY(),4 * BitmapInterface.TILE_SIZE + 320, 0);
    }

    @Test
    public void testPlayerCollision() {
        Player player = Player.getPlayer();
        GameScreenViewModel viewModel = new GameScreenViewModel();
        player.setX(170);
        player.setY(480);

        ArrayList<Rect> walls = Wall.getWall().getWalls();

        assertFalse(viewModel.checkCollision(player, walls));

    }
}
