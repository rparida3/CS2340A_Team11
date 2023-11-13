package com.example.cs2340a_team11.ViewModel;

import android.graphics.Rect;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team11.Environment.BitmapInterface;
import com.example.cs2340a_team11.Model.Player;
import com.example.cs2340a_team11.R;
import com.example.cs2340a_team11.View.BanditView;
import com.example.cs2340a_team11.View.EvilWizardView;
import com.example.cs2340a_team11.View.NightborneidleView;
import com.example.cs2340a_team11.View.PlayerView;
import com.example.cs2340a_team11.View.SkeletonView;

import java.util.ArrayList;

public class GameScreenViewModel extends ViewModel {
    private Player player = Player.getPlayer();

    private int charId = player.getCharId();

    private int totalScore = player.getScore();
    private int currMap;

    private Handler handler = new Handler();
    private boolean isTimerRunning = true;

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

    public void runMovement(NightborneidleView view) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (player.getX() == view.getX() && player.getY() == view.getY()) {
                    enemyAttack();
                }
                // view.runMovement();
                view.updatePosition();
                handler.postDelayed(this, 1000);
                System.out.println("Nightborne still running");
            }
        });
    }

    public void runMovement(SkeletonView view) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (player.getX() == view.getX() && player.getY() == view.getY()) {
                    enemyAttack();
                }
                // view.runMovement();
                view.updatePosition();
                handler.postDelayed(this, 1000);
                System.out.println("Skeleton still running");
            }
        });
    }

    public void runMovement(EvilWizardView view) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (player.getX() == view.getX() && player.getY() == view.getY()) {
                    enemyAttack();
                }
                // view.runMovement();
                view.updatePosition();
                handler.postDelayed(this, 1000);
                System.out.println("Skeleton still running");
            }
        });
    }

    public void runMovement(BanditView view) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (player.getX() == view.getX() && player.getY() == view.getY()) {
                    enemyAttack();
                }
                view.updatePosition();
                handler.postDelayed(this, 1000);
                System.out.println("Skeleton still running");
            }
        });
    }
    public void enemyAttack() {
        if (player.getDifficulty().equals("Easy")) {
            player.setHP(player.getHP() - 10);
        } else if (player.getDifficulty().equals("Medium")) {
            player.setHP(player.getHP() - 20);
        } else {
            player.setHP(player.getHP() - 30);
        }
    }

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
                healthBar.setProgress(player.getHP());
                handler.postDelayed(this, 10);
            }
        });
    }
}
