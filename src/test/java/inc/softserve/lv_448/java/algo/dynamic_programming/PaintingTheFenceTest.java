package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaintingTheFenceTest {

    private PaintingTheFence testClass;

    @BeforeEach
    void setUp() {
        testClass = new PaintingTheFence();
    }

    @Test
    void paintingTheFence3And2() {
        long actual;
        int expected = 6;

        int n = 3;
        int k = 2;

        actual = testClass.countWays(n, k);
        assertEquals(expected, actual);
    }

    @Test
    void paintingTheFence2And4() {
        long actual;
        int expected = 16;

        int n = 2;
        int k = 4;

        actual = testClass.countWays(n, k);
        assertEquals(expected, actual);
    }

}
