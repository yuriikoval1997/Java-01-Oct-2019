package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToCalculateSumTest {
    private WaysToCalculateSum test;

    @BeforeEach
    void setUp() {
        test = new WaysToCalculateSum();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void calculateWays() {
        assertEquals(1, test.calculateWays(-1));
        assertEquals(1, test.calculateWays(0));
        assertEquals(2, test.calculateWays(3));
        assertEquals(10, test.calculateWays(6));
    }

}