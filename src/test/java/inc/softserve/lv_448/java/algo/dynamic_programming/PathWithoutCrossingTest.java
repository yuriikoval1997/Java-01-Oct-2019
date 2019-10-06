package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathWithoutCrossingTest {

    private static PathWithoutCrossing countPathCrossing;

    @BeforeAll
    static void init(){
        countPathCrossing = new PathWithoutCrossing();
    }

    @Test
    void testRun(){
        int actual = 6;
        int expected = 5;
        assertEquals(expected, countPathCrossing.calculate(actual));
    }

    @Test
    void testZero(){
        int actual = 3;
        int expected = 0;
        assertEquals(expected, countPathCrossing.calculate(actual));
    }

    @AfterAll
    static void deleteObject(){
        countPathCrossing = null;
    }

}