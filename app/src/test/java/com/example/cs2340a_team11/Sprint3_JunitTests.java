package com.example.cs2340a_team11;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.View.Maps.MapOneActivity;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;

public class Sprint3_JunitTests {
    /**
     * @author Raj Parida
     * Tests level starting placement between stages 1 & 2.
     */
    @Test
    public void testPlacement1X() {
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setCurrMap(1);
        testModel.setPlayerStarting(1);
        assertEquals(Player.getPlayer().getX(),3 * BitmapInterface.TILE_SIZE + 320, 0);
    }
    @Test
    public void testPlacement1Y() {
        GameScreenViewModel testModel = new GameScreenViewModel();
        testModel.setCurrMap(1);
        testModel.setPlayerStarting(1);
        assertEquals(Player.getPlayer().getY(),3 * BitmapInterface.TILE_SIZE, 0);
    }



}
