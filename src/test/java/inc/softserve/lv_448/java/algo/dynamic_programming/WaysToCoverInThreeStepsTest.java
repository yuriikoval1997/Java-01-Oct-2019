package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WaysToCoverInThreeStepsTest {
    private WaysToCoverInThreeSteps w;

    @BeforeEach
    void setUp() {
        w = new WaysToCoverInThreeSteps();
    }

    @Test
    void calculateNumberOfWays() {
        assertEquals(13, w.calculateNumberOfWays(5));
        assertEquals(5768, w.calculateNumberOfWays(15));
        assertEquals(0, w.calculateNumberOfWays(-4));
        assertEquals(1, w.calculateNumberOfWays(0));
        assertEquals(1, w.calculateNumberOfWays(1));
        assertEquals(2, w.calculateNumberOfWays(2));
    }
}
