package com.example.cs2340a_team11.View.Maps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.cs2340a_team11.Environment.CreatedMap;
import com.example.cs2340a_team11.Model.Wall;
import com.example.cs2340a_team11.ViewModel.GameScreenViewModel;


public class MapView extends View {
    private CreatedMap testMap;
    private Wall walls = Wall.getWall();
    private Paint color = new Paint();

    public MapView(Context context, int mapValue) {
        super(context);
        color.setColor(Color.BLACK);
        color.setAlpha(10);

        // the actual 2D array for the map
        int[][] mapArray = new int[8][7];

        // chosen int is the tile we want to select from our tileset

        if (mapValue == 1) {
            // FIRST MAP (just a square room)

            // top walls
            for (int k = 1; k < mapArray[0].length - 1; k++) {
                mapArray[0][k] = 1;
            }

            mapArray[0][mapArray[0].length - 1] = 5; // top right corner wall

            // inner layers
            for (int j = 1; j < mapArray.length; j++) {
                mapArray[j][0] = 0;
                for (int i = 1; i < mapArray[j].length; i++) {
                    mapArray[j][i] = 9;
                }
                mapArray[j][mapArray[0].length - 1] = 5;
            }

            // bottom walls
            for (int k = 1; k < mapArray[0].length - 1; k++) {
                mapArray[mapArray.length - 1][k] = 41;
            }

            mapArray[mapArray.length - 1][0] = 40; // bottom left corner wall
            mapArray[mapArray.length - 1][mapArray[0].length - 1] = 45; // bottom right corner wall
        } else if (mapValue == 2) {
            // SECOND MAP (same as map 1)
            mapArray = new int[][]{
                    {0, 11, 12, 3, 4, 1, 5},
                    {10, 11, 12, 13, 12, 14, 15},
                    {20, 21, 71, 72, 73, 24, 25},
                    {30, 21, 71, 72, 73, 24, 35},
                    {0, 21, 71, 72, 73, 24, 5},
                    {10, 21, 71, 72, 73, 24, 15},
                    {20, 31, 32, 33, 32, 34, 25},
                    {40, 41, 42, 43, 44, 41, 45}
            };
        } else if (mapValue == 3) {
            // THIRD MAP (leads down a hallway
            mapArray = new int[][]{
                    {0, 1, 2, 3, 4, 1, 5},
                    {10, 11, 12, 13, 12, 14, 15},
                    {20, 21, 71, 72, 73, 24, 25},
                    {30, 21, 71, 72, 73, 24, 35},
                    {40, 41, 42, 53, 73, 24, 5},
                    {78, 78, 78, 10, 21, 24, 15},
                    {78, 78, 78, 20, 21, 24, 25},
                    {78, 78, 78, 30, 21, 24, 5}
            };
        }

        if (mapValue == 12) {
            // insert items into square room (like 2)
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    mapArray[i][j] = -1;
                }
            }
            mapArray[0][1] = 36;
            mapArray[0][2] = 37;
            mapArray[0][4] = 90;
            mapArray[3][5] = 82;
            mapArray[6][2] = 77;
            mapArray[5][5] = 49;
            mapArray[6][1] = 64;
            mapArray[6][5] = 94;
        } else if (mapValue == 13) {
            // insert items into square room (like 2)
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    mapArray[i][j] = -1;
                }
            }
            mapArray[7][1] = 36; // doors
            mapArray[7][2] = 37;
            mapArray[3][3] = 87; // potion
            mapArray[2][5] = 77; // skull
            mapArray[1][1] = 39; // ladder
            mapArray[6][5] = 96; // torch
        } else if (mapValue == 14) {
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    mapArray[i][j] = -1;
                }
            }

            mapArray[7][4] = 36;
            mapArray[7][5] = 37;
        }
        testMap = new CreatedMap(mapArray);
    }

    protected void onDraw(Canvas canvas) {
        //System.out.print("onDraw [[Mapview]]... ");
        super.onDraw(canvas);
        // System.out.println("After super.ondraw(Canvas)");
        testMap.draw(canvas);

        // System.out.println("MapView onDraw walls: " + walls.getWalls().size());
        if (!walls.getIsDrawn()) {
            for (Rect wall : walls.getWalls()) {
                canvas.drawRect(wall, color);
            }
            walls.setIsDrawn(true);
        }
    }
}
