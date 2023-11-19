package com.example.cs2340a_team11.ViewModel;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Enemies.Bandit;
import com.example.cs2340a_team11.Model.Enemies.Enemy;
import com.example.cs2340a_team11.Model.Enemies.EvilWizard;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.EntityViews.BanditView;
import com.example.cs2340a_team11.View.EntityViews.EnemyView;
import com.example.cs2340a_team11.View.EntityViews.EvilWizardView;
import com.example.cs2340a_team11.View.EntityViews.NightborneidleView;
import com.example.cs2340a_team11.View.EntityViews.PlayerView;
import com.example.cs2340a_team11.View.EntityViews.SkeletonView;
import com.example.cs2340a_team11.ViewModel.Collisions.CollisionHandler;
import com.example.cs2340a_team11.ViewModel.Collisions.CollisionObserver;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveDownStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveLeftStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveRightStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MoveUpStrategy;
import com.example.cs2340a_team11.ViewModel.Collisions.MovementStrategy;

import java.util.ArrayList;

public class GameScreenViewModel extends ViewModel {
    private Player player = Player.getPlayer();
    private int charId = player.getCharId();
    private int totalScore = player.getScore();
    private int currMap;
    private MutableLiveData<Boolean> isGameOver = new MutableLiveData<>();

    private Handler handler = new Handler();
    private boolean isTimerRunning = true;
    private final int playerHp = player.getInitialHP();
    public GameScreenViewModel() {

    }

    public int getImg() {
        System.out.println(charId);
        if (charId == R.id.wizardButton) {
            return R.drawable.wizard;
        } else if (charId == R.id.assassinButton) {
            return R.drawable.samurai;
        } else if (charId == R.id.knightButton) {
            return R.drawable.knight;
        }
        return R.drawable.wizard;
    }

    public void setPlayerStarting(int mapLevel) {
        if (mapLevel == 1) {
            // sets in [4][3] of mapView array
            player.setY(4 * BitmapInterface.TILE_SIZE + 320);
            player.setX(3 * BitmapInterface.TILE_SIZE);
            currMap = 1;
        } else if (mapLevel == 2) {
            // sets in [6][1]
            player.setY(6 * BitmapInterface.TILE_SIZE + 320);
            player.setX(BitmapInterface.TILE_SIZE);
            currMap = 2;
        } else if (mapLevel == 3) {
            // sets in [1][1]
            player.setY(BitmapInterface.TILE_SIZE + 320);
            player.setX(BitmapInterface.TILE_SIZE);
            currMap = 3;
        } else {
            player.setY(320);
            player.setX(0);
        }
        player.displayPosition();
    }

    public void runTimer(TextView timeView) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                totalScore++;
                player.setScore(totalScore);
                String score = Integer.toString(totalScore);
                timeView.setText(score);
                if (isTimerRunning) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    public void stopTimer() {
        isTimerRunning = false;
        handler.removeCallbacksAndMessages(null);
    }
    /*
    public void runMovement(NightborneidleView view) {
        CollisionObserver collisionObserver = new CollisionHandler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (collisionObserver.checkEnemyCollision(player, view.getNightborne())) {
                    view.getNightborne().enemyAttack();
                }
                // view.runMovement();
                view.updatePosition();
                handler.postDelayed(this, 800);
                System.out.println("Nightborne still running");
            }
        });
    }

    public void runMovement(SkeletonView view) {
        CollisionObserver collisionObserver = new CollisionHandler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (collisionObserver.checkEnemyCollision(player, view.getSkeleton())) {
                    view.getSkeleton().enemyAttack();
                }
                // view.runMovement();
                view.updatePosition();
                handler.postDelayed(this, 1000);
                System.out.println("Skeleton still running");
            }
        });
    }

    public void runMovement(EvilWizardView view, ArrayList<Rect> walls, EvilWizard wiza) {
        CollisionObserver collisionObserver = new CollisionHandler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                MovementStrategy ms = null;
                String dir = view.getDir();
                // if (collisionObserver.checkEnemyCollision(player, view.getEvilWizard())) {
                //     view.getEvilWizard().enemyAttack();
                // }
                // view.runMovement();
                switch (dir) {
                    case "L":
                        ms = new MoveLeftStrategy();
                        System.out.println("Left");
                        break;
                    case "R":
                        ms = new MoveRightStrategy();
                        System.out.println("Right");
                        break;
                    case "D":
                        System.out.println("Down");
                        ms = new MoveDownStrategy();
                        break;
                    case "U":
                        ms = new MoveUpStrategy();
                        System.out.println("Up");
                        break;
                    default:
                        System.out.println("Nope");
                        break;
                }

                if (ms != null) {
                    ms.move(wiza);

                    for (Rect wall: walls) {
                        if (checkCollision(wiza, wall)) {
                            System.out.println("Wizard collide with wall?");
                            collisionObserver.collision(wiza, ms);
                            break;
                        }
                    }
                    // view.updatePosition();
                    view.updatePosition(wiza.getX(), wiza.getY());
                }
                // view.updatePosition();
                handler.postDelayed(this, 1200);
                // System.out.println("Wizard still running");
            }
        });
    }

    public void runMovement(BanditView view, ArrayList<Rect> walls, Bandit bandit) {
        CollisionObserver collisionObserver = new CollisionHandler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                MovementStrategy ms = null;
                //if (collisionObserver.checkEnemyCollision(player, view.getBandit())) {
                //    view.getBandit().enemyAttack();
                //}
                // bandit.displayPosition();
                String dir = view.getDir();
                switch (dir) {
                    case "L":
                        ms = new MoveLeftStrategy();
                        //System.out.println("Left");
                        break;
                    case "R":
                        ms = new MoveRightStrategy();
                        //System.out.println("Right");
                        break;
                    case "D":
                        //System.out.println("Down");
                        ms = new MoveDownStrategy();
                        break;
                    case "U":
                        ms = new MoveUpStrategy();
                        //System.out.println("Up");
                        break;
                    default:
                        System.out.println("Nope");
                        break;
                }

                if (ms != null) {
                    ms.move(bandit);

                    for (Rect wall: walls) {
                        if (checkCollision(bandit, wall)) {
                            //System.out.println("Bandit collide with wall?");
                            collisionObserver.collision(bandit, ms);
                            break;
                        }
                    }
                    // view.updatePosition();
                    view.updatePosition(bandit.getX(), bandit.getY());
                }
                handler.postDelayed(this, 800);
                //System.out.println("Bandit still running!!!!!!!!!");
            }
        });
    }
*/
    public void stopMovement() {
        handler.removeCallbacksAndMessages(null);
    }

    public void onKeyDown(int keyCode, KeyEvent event, PlayerView view, ArrayList<Rect> walls) {
        // player.displayPosition();
        MovementStrategy movementStrategy = null;
        CollisionObserver collisionObserver = new CollisionHandler();

        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            movementStrategy = new MoveLeftStrategy();
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            movementStrategy = new MoveRightStrategy();
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            movementStrategy = new MoveDownStrategy();
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            movementStrategy = new MoveUpStrategy();
            break;
        default:
            break;
        }

        if (movementStrategy != null) {
            movementStrategy.move(player);

            for (Rect wall: walls) {
                if (checkCollision(player, wall)) {
                    collisionObserver.collision(player, movementStrategy);
                    break; // do not delete.
                    // This break statement is vital in implementing observer pattern
                    // since it makes sure only one collision is dealt with at any given
                    // time.
                }
            }

            view.updatePosition(player.getX(), player.getY());
        }
    }

    public void runMovement(EnemyView view, ArrayList<Rect> walls, Enemy enemy) {
        CollisionObserver collisionObserver = new CollisionHandler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                MovementStrategy ms = null;
                String dir = view.getDir();
                // if (collisionObserver.checkEnemyCollision(player, view.getEvilWizard())) {
                //     view.getEvilWizard().enemyAttack();
                // }
                // view.runMovement();
                switch (dir) {
                    case "L":
                        ms = new MoveLeftStrategy();
                        System.out.println("Left");
                        break;
                    case "R":
                        ms = new MoveRightStrategy();
                        System.out.println("Right");
                        break;
                    case "D":
                        System.out.println("Down");
                        ms = new MoveDownStrategy();
                        break;
                    case "U":
                        ms = new MoveUpStrategy();
                        System.out.println("Up");
                        break;
                    default:
                        System.out.println("Nope");
                        break;
                }

                if (ms != null) {
                    ms.move(enemy);

                    for (Rect wall: walls) {
                        if (checkCollision(enemy, wall)) {
                            System.out.println("Enemy collide with wall?");
                            collisionObserver.collision(enemy, ms);
                            break;
                        }
                    }
                    // view.updatePosition();
                    view.updatePosition(enemy.getX(), enemy.getY());
                }
                // view.updatePosition();
                handler.postDelayed(this, 1200);
                // System.out.println("Enemy still running");
            }
        });
    }

    /* NEW checkCollision() method
       Only major change is that instead of taking in an
       ArrayList of Rect objects, it takes in a single
       Rect object. As a result, I no longer needed the
       for-loop (that looped thru the ArrayList).
       Instead, I have the for-loop in the onKeyDown()
       method (see above). Let me (yash) know if
       something doesn't make sense.
     */
    public boolean checkCollision(Player player, Rect wall) {
        Rect r1 = new Rect((int) player.getX(),
                (int) player.getY() - 320,
                (int) player.getX() + 160,
                (int) player.getY() - 160);
        System.out.println("Player rect: " + r1);

        if (r1.intersect(wall)) {
            System.out.println("INTERSECT IS TRUE");
            System.out.println("Wall rect: " + wall);
            return true;
        }

        return false;
    }

    public boolean checkCollision(Enemy enemy, Rect wall) {
        Rect r1 = new Rect((int) enemy.getX(),
                (int) enemy.getY() - 320,
                (int) enemy.getX() + 160,
                (int) enemy.getY() - 160);

        return r1.intersect(wall);
    }

    public boolean checkDoor() {
        if (currMap == 1) {
            if (player.getY() <= 320) {
                return true;
            }
        }
        if (currMap == 2) {
            if (player.getX() == 160 && player.getY() == 480) {
                return true;
            }
        }
        if (currMap == 3) {
            if (player.getY() >= 1440) {
                return true;
            }
        }
        return false;
    }

    /**
     * The bottom two methods are used ONLY for testing purposes. Do not do anything with them!
     * @author Raj Parida
     * @return current map.
     */
    public int getCurrMap() {
        return this.currMap;
    }

    public void setCurrMap(int value) {
        this.currMap = value;
    }

    // DO PLEASE: method to update player health
    public void updatePlayerHealth(ProgressBar healthBar) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                healthBar.setProgress((int) (100 * ((float) player.getHP() / playerHp)));
                checkGameOver();
                if (player.getHP() > 0) {
                    handler.postDelayed(this, 1);
                }
            }
        });
    }
    public void checkGameOver() {
        if (player.isGameOver()) {
            isGameOver.setValue(true);
        }
    }
    public LiveData<Boolean> getIsGameOver() {
        return isGameOver;
    }

    public void attackAdj() {
        Rect r1 = new Rect((int) player.getX() - 160,
                (int) player.getY() - 320 - 160,
                (int) player.getX() + 160 + 160,
                (int) player.getY() - 160 - 160);

    }
}
