package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BucketSortTest extends ArraySortTest{
    @BeforeEach
    void setUp(){
        sort = new BucketSort();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void accept(TestData testData){
        sort.accept(testData.actual);
        assertArrayEquals(testData.expected, testData.actual);
    }
}
