package com.example.cs2340a_team11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.cs2340a_team11.Environment.FirstMap;

import java.util.Arrays;

public class MapView extends View {
    private FirstMap testMap;
    public MapView(Context context) {
        super(context);

        // the actual 2D array for the map
        int[][] testArray = new int[8][7];

        // chosen int is the tile we want to select from our tileset

        // top walls
        for (int k = 1; k < testArray[0].length - 1; k++) {
            testArray[0][k] = 1;
        }

        testArray[0][6] = 5; // top right corner wall

        // inner layers
        for (int j = 1; j < testArray.length; j++) {
            testArray[j][0] = 0;
            for (int i = 1; i < testArray[j].length; i++) {
                testArray[j][i] = 9;
            }
            testArray[j][6] = 5;
        }

        // bottom walls
        for (int k = 1; k < testArray[0].length - 1; k++) {
            testArray[7][k] = 41;
        }

        testArray[7][0] = 40; // bottom left corner wall
        testArray[7][6] = 45; // bottom right corner wall
        testMap = new FirstMap(testArray);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testMap.draw(canvas);
    }
}
