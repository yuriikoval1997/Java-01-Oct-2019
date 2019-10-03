package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ArraySortTest {

    ArraySort arraySort;

    @SuppressWarnings("unused")
    static Stream<TestData> supplyTestData(){
        List<TestData> tests = new ArrayList<>();
        tests.add(new TestData(new int[]{64, 34, 25, 12, 22, 11, 90, 87}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{11, 12, 22, 25, 34, 64, 87, 90}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{90, 87, 64, 34, 25, 22, 12, 11}, new int[]{11, 12, 22, 25, 34, 64, 87, 90}));
        tests.add(new TestData(new int[]{64, 34, 25, 12, 22, 11, 90, 87, 0}, new int[]{0, 11, 12, 22, 25, 34, 64, 87, 90}));
        return tests.stream();
    }

    static class TestData{
        final int[] actual;
        final int[] expected;

        TestData(int[] actual, int[] expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }
}