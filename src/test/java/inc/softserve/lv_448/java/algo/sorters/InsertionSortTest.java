package inc.softserve.lv_448.java.algo.sorters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest extends SortTest{

    @BeforeEach
    void setUp() {
        sort = new InsertionSort();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void accept(TestData testData) {
        sort.accept(testData.actual);
        assertArrayEquals(testData.expected, testData.actual);
    }
}