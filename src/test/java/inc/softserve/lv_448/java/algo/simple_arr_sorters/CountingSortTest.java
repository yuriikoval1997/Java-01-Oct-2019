package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingSortTest {
    private Sort sort;

    @BeforeEach
    void setUp() {
        sort = new CountingSort();
    }

    @ParameterizedTest
    @MethodSource("supplyWithPositiveNumbers")
    void accept(ArraySortTest.TestData testData) {
        sort.accept(testData.actual);
        assertArrayEquals(testData.expected, testData.actual);
    }

    @Test
    void acceptFailsWithIllegalArgument() {
        int[] array = new int[]{1, 7, -5, 10};

        Assertions.assertThrows(IllegalArgumentException.class, () -> sort.accept(array));
    }

    static Stream<ArraySortTest.TestData> supplyWithPositiveNumbers() {
        List<ArraySortTest.TestData> tests = new ArrayList<>();

        tests.add(new ArraySortTest.TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{64, 34, 25, 12, 22, 11, 90, 87}));
        tests.add(new ArraySortTest.TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new ArraySortTest.TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{90, 87, 64, 34, 25, 22, 12, 11}));
        tests.add(new ArraySortTest.TestData(new int[]{0, 11, 12, 22, 25, 34, 64, 87, 90}, new int[]{64, 34, 25, 12, 22, 11, 90, 87, 0}));
        tests.add(new ArraySortTest.TestData(new int[]{0}, new int[]{0}));

        return tests.stream();
    }
}
