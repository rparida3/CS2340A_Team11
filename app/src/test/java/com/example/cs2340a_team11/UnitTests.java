package com.example.cs2340a_team11;


import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340a_team11.ViewModel.InitialConfigViewModel;

public class UnitTests {
    @Test
    public void blankName_returnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName(""));
    }

    @Test
    public void whitespaceName_returnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName("   "));
    }

    @Test
    public void nullName_returnsFalse() {
        InitialConfigViewModel sample = new InitialConfigViewModel();
        assertFalse(sample.checkName(null));
    }
}
