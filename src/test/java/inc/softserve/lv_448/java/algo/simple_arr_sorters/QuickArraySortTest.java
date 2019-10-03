package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickArraySortTest extends ArraySortTest {

    @BeforeEach
    void setUp() {
        arraySort = new InsertionArraySort();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void accept(InsertionArraySortTest.TestData testData) {
        arraySort.accept(testData.actual);
        assertArrayEquals(testData.expected, testData.actual);
    }
}