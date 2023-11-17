package com.example.cs2340a_team11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.example.cs2340a_team11.Model.Enemies.Nightborneidle;
import com.example.cs2340a_team11.Model.Player;

import org.junit.Test;

public class Sprint4_Tests {
    @Test
    public void testEnemyAttack() {
        Player player = Player.getPlayer();
        player.setDifficulty("Easy");
        Nightborneidle nightborneidle = new Nightborneidle();
        player.setX(nightborneidle.getX());
        player.setY(nightborneidle.getY());
        nightborneidle.enemyAttack();
        assertEquals(Player.getPlayer().getHP(), Player.getPlayer().getInitialHP() - 5, 0);
    }

    @Test
    public void testEnemyAttackMedium() {
        Player player = Player.getPlayer();
        player.setDifficulty("Medium");
        Nightborneidle nightborneidle = new Nightborneidle();
        player.setX(nightborneidle.getX());
        player.setY(nightborneidle.getY());
        nightborneidle.enemyAttack();
        assertEquals(Player.getPlayer().getHP(), Player.getPlayer().getInitialHP() - 8, 0);
    }
    @Test
    public void testEnemyAttackHard() {
        Player player = Player.getPlayer();
        player.setDifficulty("Hard");
        Nightborneidle nightborneidle = new Nightborneidle();
        player.setX(nightborneidle.getX());
        player.setY(nightborneidle.getY());
        nightborneidle.enemyAttack();
        assertEquals(Player.getPlayer().getHP(), Player.getPlayer().getInitialHP() - 12, 0);
    }

    @Test
    public void testInitialWizardHP() {
        Player player = Player.getPlayer();
        player.setDifficulty("Easy");
        player.setCharId(R.id.wizardButton);
        assertEquals(player.getInitialHP(), 30);
    }

    @Test
    public void testInitialAssassinHP() {
        Player player = Player.getPlayer();
        player.setDifficulty("Easy");
        player.setCharId(R.id.assassinButton);
        assertEquals(player.getInitialHP(), 20);
    }

    @Test
    public void testInitialKnightHP() {
        Player player = Player.getPlayer();
        player.setDifficulty("Easy");
        player.setCharId(R.id.knightButton);
        assertEquals(player.getInitialHP(), 50);
    }

}
