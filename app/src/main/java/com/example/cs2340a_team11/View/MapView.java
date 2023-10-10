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
        int[][] testArray = new int[10][3];
        for (int j = 0; j < testArray.length; j++) {
            // VAL is the tile we want to select from our tileset
            Arrays.fill(testArray[j], 67);
        }

        testMap = new FirstMap(testArray);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testMap.draw(canvas);
    }
}
