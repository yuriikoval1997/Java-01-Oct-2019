package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaysToTileTheFloorTest {

    private WaysToTileTheFloor testClass;

    @BeforeAll
    public void setUp() throws Exception {
        testClass = new WaysToTileTheFloor();
    }

    @AfterAll
    public void cleanUp() throws Exception {
        testClass = null;
    }

    @Test
    public void lowOrHighEffort() {
        int actual;
        int expected = 5;

        int n = 7;
        int m = 4;

        actual = testClass.countWays(n, m);

        assertEquals(expected, actual);
    }
}
