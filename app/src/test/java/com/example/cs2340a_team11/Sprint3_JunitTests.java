package com.example.cs2340a_team11;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.ViewModel.Collisions.CollisionHandler;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveDownStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveLeftStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveRightStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveUpStrategy;

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

    /**
     * @author Darshan Singh
     * Series of tests to see if player up and down movement is working.
     */
    @Test
    public void testMoveUp() {
        Player.getPlayer().setX(300);
        Player.getPlayer().setY(500);
        assertEquals(Player.getPlayer().getX(), 300, 0);
        assertEquals(Player.getPlayer().getY(), 500, 0);

        Player.getPlayer().moveUp();

        assertEquals(Player.getPlayer().getY(), 340, 0); // x-coord stays the same
        assertEquals(Player.getPlayer().getX(), 300, 0); // 340 = 500 - 160
    }

    @Test
    public void testMoveDown() {
        Player.getPlayer().setX(300);
        Player.getPlayer().setY(500);
        assertEquals(Player.getPlayer().getX(), 300, 0);
        assertEquals(Player.getPlayer().getY(), 500, 0);

        Player.getPlayer().moveDown();

        assertEquals(Player.getPlayer().getY(), 660, 0); //660 = 500 + 160
        assertEquals(Player.getPlayer().getX(), 300, 0); // x-coord stays the same
    }

    /**
     * @author Rick Nguyen
     * Series of tests to see if collision handler works by checking if player position does not
     * change upon colliding
     */
    @Test
    public void checkHorizontalMovementCollision() {
        Player player = Player.getPlayer();
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setPlayerStarting(1);
        float prevX = player.getX();
        float prevY = player.getY();
        player.moveRight();
        CollisionHandler cH = new CollisionHandler();
        cH.collision(player, new MoveRightStrategy());
        player.moveLeft();
        cH.collision(player, new MoveLeftStrategy());
        float postX = player.getX();
        float postY = player.getY();
        assertEquals(postX, prevX, 0);
        assertEquals(postY, prevY, 0);
    }

    @Test
    public void checkVerticalMovementCollision() {
        Player player = Player.getPlayer();
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setPlayerStarting(1);
        float prevX = player.getX();
        float prevY = player.getY();
        player.moveUp();
        CollisionHandler cH = new CollisionHandler();
        cH.collision(player, new MoveUpStrategy());
        player.moveDown();
        cH.collision(player, new MoveDownStrategy());
        float postX = player.getX();
        float postY = player.getY();
        assertEquals(postX, prevX, 0);
        assertEquals(postY, prevY, 0);
    }
}
