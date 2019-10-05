package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ArraySortTest {

    Sort sort;

    @SuppressWarnings("unused")
    static Stream<TestData> supplyTestData(){
        List<TestData> tests = new ArrayList<>();
        tests.add(new TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{64, 34, 25, 12, 22, 11, 90, 87}));
        tests.add(new TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{90, 87, 64, 34, 25, 22, 12, 11}));
        tests.add(new TestData(new int[]{0, 11, 12, 22, 25, 34, 64, 87, 90}, new int[]{64, 34, 25, 12, 22, 11, 90, 87, 0}));

        for (int i = 0; i < 100; i++) {
            Random random = new Random(i);
            int[] actual = IntStream.generate(random::nextInt)
                    .limit(10_000)
                    .toArray();
            int[] expected = new int[actual.length];
            System.arraycopy(actual, 0, expected, 0, actual.length);
            Arrays.sort(expected);
            tests.add(new TestData(expected, actual));
        }
        return tests.stream();
    }

    static class TestData{
        final int[] expected;
        final int[] actual;

        TestData(int[] expected, int[] actual) {
            this.expected = expected;
            this.actual = actual;
        }
    }
}