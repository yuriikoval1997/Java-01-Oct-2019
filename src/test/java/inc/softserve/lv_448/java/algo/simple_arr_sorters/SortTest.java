package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SortTest {

    Sort<Integer> sort;

    @SuppressWarnings("unused")
    static Stream<TestData> supplyTestData(){
        List<TestData> tests = new ArrayList<>();
        tests.add(new TestData(Arrays.asList(11, 12, 22, 25, 34, 64, 87, 90), Arrays.asList(64, 34, 25, 12, 22, 11, 90, 87)));
        tests.add(new TestData(Arrays.asList(11, 12, 22, 25, 34, 64, 87, 90), Arrays.asList(11, 12, 22, 25, 34, 64, 87, 90)));
        tests.add(new TestData(Arrays.asList(11, 12, 22, 25, 34, 64, 87, 90), Arrays.asList(90, 87, 64, 34, 25, 22, 12, 11)));
        tests.add(new TestData(Arrays.asList(0, 11, 12, 22, 25, 34, 64, 87, 90), Arrays.asList(64, 34, 25, 12, 22, 11, 90, 87, 0)));

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            List<Integer> actual = Stream.generate(random::nextInt)
                    .limit(10_000)
                    .collect(Collectors.toList());
            List<Integer> expected = new ArrayList<>(actual);
            Collections.sort(expected);
            tests.add(new TestData(expected, actual));
        }
        return tests.stream();
    }

    static class TestData{
        final List<Integer> expected;
        final List<Integer> actual;

        TestData(List<Integer> expected, List<Integer> actual) {
            this.expected = expected;
            this.actual = actual;
        }
    }
}