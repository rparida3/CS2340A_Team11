package com.example.cs2340a_team11;
import org.junit.Test;

import static org.junit.Assert.*;
import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Factories.BanditFactory;
import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Factories.EvilWizardFactory;
import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.Model.Enemies.Skeleton;
public class Sprint4JunitTests {
    @Test
    public void enemyMovementDownLeftTest() {
        Nightborneidle nb = new Nightborneidle();
        nb.moveDown();
        nb.moveLeft();
        nb.moveDown();
        nb.moveDown();
        assertEquals(-BitmapInterface.TILE_SIZE, nb.getX(), 0);
        assertEquals(3 * BitmapInterface.TILE_SIZE, nb.getY(), 0);
    }
    @Test
    public void enemyMovementRightLeftTest() {
        Skeleton sk = new Skeleton();
        for (int i = 0; i < 10; i++) {
            sk.moveRight();
            sk.moveLeft();
        }
        assertEquals(0, sk.getY(), 0);
        assertEquals(0, sk.getX(), 0);
    }
    @Test
    public void wizardDeathTest() {
        Player player = Player.getPlayer();
        player.setCharId(R.id.wizardButton);
        player.setDifficulty("Easy");
        EvilWizard evilWizard = new EvilWizard();
        evilWizard.enemyAttack();
        assertEquals(player.getHP(), player.getInitialHP() - 5, 0);
        for (int i = 0; i < 5; i++) {
            evilWizard.enemyAttack();
        }
        assertEquals(player.getHP(), player.getInitialHP() - 30, 0);
        assertTrue(player.isGameOver());
    }
    @Test
    public void knightDeathTest() {
        Player player = Player.getPlayer();
        player.setCharId(R.id.knightButton);
        player.setDifficulty("Medium");
        Bandit bandit = new Bandit();
        bandit.enemyAttack();
        assertEquals(player.getHP(), player.getInitialHP() - 8, 0);
        for (int i = 0; i < 4; i++) {
            bandit.enemyAttack();
        }
        assertEquals(player.getHP(), player.getInitialHP() - 40, 0);
        assertTrue(player.isGameOver());
    }
    @Test
    public void assassinDeathTest() {
        Player player = Player.getPlayer();
        player.setCharId(R.id.assassinButton);
        player.setDifficulty("Hard");
        Skeleton skeleton = new Skeleton();
        skeleton.enemyAttack();
        assertEquals(player.getHP(), player.getInitialHP() - 12, 0);
        assertTrue(player.isGameOver());
    }
    @Test
    public void enemyFactoryPatternTest() {
        BanditFactory bd = new BanditFactory();
        Enemy random = bd.createEnemy();
        assertTrue(random instanceof Bandit);
        EvilWizardFactory ev = new EvilWizardFactory();
        random = ev.createEnemy();
        assertTrue(random instanceof EvilWizard);
    }
}
