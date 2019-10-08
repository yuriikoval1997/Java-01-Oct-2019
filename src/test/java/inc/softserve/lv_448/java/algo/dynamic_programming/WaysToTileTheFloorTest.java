package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaysToTileTheFloorTest {

    private WaysToTileTheFloor testClass;

    @BeforeEach
    void setUp() {
        testClass = new WaysToTileTheFloor();
    }

    @Test
    void waysToTileTheFloor() {
        int actual;
        int expected = 5;

        int n = 7;
        int m = 4;

        actual = testClass.countWays(n, m);

        assertEquals(expected, actual);
    }
}
