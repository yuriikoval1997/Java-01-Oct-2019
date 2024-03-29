package inc.softserve.lv_448.java.algo.sorters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class QuickSortTest extends SortTest {

    @BeforeEach
    void setUp() {
        sort = new InsertionSort<>();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void accept(InsertionSortTest.TestData testData) {
        sort.accept(testData.actual);
        assertEquals(testData.expected, testData.actual);
    }
}