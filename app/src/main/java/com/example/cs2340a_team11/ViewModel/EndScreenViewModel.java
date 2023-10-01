package com.example.cs2340a_team11.ViewModel;

import androidx.lifecycle.ViewModel;

public class EndScreenViewModel extends ViewModel {
    public EndScreenViewModel() {

    }

    // DO PLEASE: fetch results from player and return to view
    public String fetchResult() {
        return "Won";
    }

    public int fetchKilled() {
        return 0;
    }

    public int fetchBoost() {
        return 0;
    }

    public int calcTotalScore() {
        return 0;
    }
}
