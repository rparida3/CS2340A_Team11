package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Environment.createdMap;

public class MapView extends View {
    private createdMap testMap;
    public MapView(Context context, int mapValue) {
        super(context);

        // the actual 2D array for the map
        int[][] mapArray = new int[8][7];

        // chosen int is the tile we want to select from our tileset

        if (mapValue == 1) {
            // FIRST MAP

            // top walls
            for (int k = 1; k < mapArray[0].length - 1; k++) {
                mapArray[0][k] = 1;
            }

            mapArray[0][6] = 5; // top right corner wall

            // inner layers
            for (int j = 1; j < mapArray.length; j++) {
                mapArray[j][0] = 0;
                for (int i = 1; i < mapArray[j].length; i++) {
                    mapArray[j][i] = 9;
                }
                mapArray[j][6] = 5;
            }

            // bottom walls
            for (int k = 1; k < mapArray[0].length - 1; k++) {
                mapArray[7][k] = 41;
            }

            mapArray[7][0] = 40; // bottom left corner wall
            mapArray[7][6] = 45; // bottom right corner wall
        } else if (mapValue == 2) {
            // SECOND MAP

            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    mapArray[i][j] = 0;
                }
            }
        }


        testMap = new createdMap(mapArray);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testMap.draw(canvas);
    }
}
