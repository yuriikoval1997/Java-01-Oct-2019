package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighLowEffortTest {

    private HighLowEffort testClass;

    @BeforeAll
    public void setUp() {
        testClass = new HighLowEffort();
    }

    @AfterAll
    public void cleanUp() {
        testClass = null;
    }

    @Test
    public void lowOrHighEffort() {
        int actual;
        int expected = 20;

        int numberOfDays = 5;
        ArrayList<Integer> lowEffortTasks = new ArrayList<>(Arrays.asList(1, 5, 4, 5, 3));
        ArrayList<Integer> highEffortTasks = new ArrayList<>(Arrays.asList(3, 6, 8, 7, 6));

        actual = testClass.getAmountOfCost(numberOfDays, lowEffortTasks, highEffortTasks);
        assertEquals(expected, actual);
    }

}
