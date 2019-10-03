package inc.softserve.lv_448.java.algo.sorters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest extends SortTest {

    @BeforeEach
    void setUp() {
        sort = new InsertionSort();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void accept(InsertionSortTest.TestData testData) {
        sort.accept(testData.actual);
        assertArrayEquals(testData.expected, testData.actual);
    }

    @SuppressWarnings("unused")
    static Stream<InsertionSortTest.TestData> supplyTestData(){
        List<InsertionSortTest.TestData> tests = new ArrayList<>();
        tests.add(new TestData(new int[]{64, 34, 25, 12, 22, 11, 90, 87}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{90, 87, 64, 34, 25, 22, 12, 11}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{64, 34, 25, 12, 22, 11, 90, 87, 0}, new int[]{0, 11, 12, 22, 25, 34, 64, 87, 90}));
        return tests.stream();
    }
}