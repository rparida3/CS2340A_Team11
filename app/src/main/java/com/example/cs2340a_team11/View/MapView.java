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
        int[][] testArray = new int[10][10];
        for (int j = 0; j < testArray.length; j++) {
            Arrays.fill(testArray[j], 0);
        }

        testMap = new FirstMap(testArray);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testMap.draw(canvas);
    }
}
