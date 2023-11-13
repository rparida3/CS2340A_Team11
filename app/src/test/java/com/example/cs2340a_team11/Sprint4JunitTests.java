package com.example.cs2340a_team11;
import org.junit.Test;

import static org.junit.Assert.*;

import android.graphics.Rect;
import android.view.KeyEvent;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.EvilWizardFactory;
import com.example.cs2340a_team11.Model.Nightborneidle;
import com.example.cs2340a_team11.Model.NightborneidleFactory;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Skeleton;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.View.GameScreenActivity;
import com.example.cs2340a_team11.View.NightborneidleView;
import com.example.cs2340a_team11.View.PlayerView;
import com.example.cs2340a_team11.ViewModel.CollisionHandler;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;
import com.example.cs2340a_team11.ViewModel.MoveDownStrategy;
import com.example.cs2340a_team11.ViewModel.MoveLeftStrategy;
import com.example.cs2340a_team11.ViewModel.MoveRightStrategy;
import com.example.cs2340a_team11.ViewModel.MoveUpStrategy;
public class Sprint4JunitTests {
    @Test
    public void NightborneMovement () {
        Nightborneidle nb = new Nightborneidle();
        nb.moveDown();
        nb.moveLeft();
        assertEquals(-BitmapInterface.TILE_SIZE, nb.getX(), 0);
        assertEquals(BitmapInterface.TILE_SIZE, nb.getY(), 0);
    }
    public void SkeletonMovement() {
        Skeleton sk = new Skeleton();
        sk.moveRight();
        sk.moveLeft();
        assertEquals(0, sk.getY(), 0);
        assertEquals(0, sk.getX(), 0 );
    }
}
