package com.company;
//package inc.softserve.lv_448.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WaysToCoverInThreeStepsTest {
    private WaysToCoverInThreeSteps w;

    @BeforeEach
    void setUp() {
        w = new WaysToCoverInThreeSteps();
    }

    @Test
    void calculateNumberOfWays() {
        assertTrue(w.calculateNumberOfWays(5) == 13);
        assertTrue(w.calculateNumberOfWays(15) == 5768);
        assertTrue(w.calculateNumberOfWays(-4) == 0);
        assertTrue(w.calculateNumberOfWays(0) == 1);
        assertTrue(w.calculateNumberOfWays(1) == 1);
        assertTrue(w.calculateNumberOfWays(2) == 2);
    }
}