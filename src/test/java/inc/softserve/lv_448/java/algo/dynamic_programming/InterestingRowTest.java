package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterestingRowTest {
    private InterestingRow test;

    @BeforeEach
    void setUp() {
        test = new InterestingRow();
    }

    @Test
    void findInterestingRowMember() {
        assertEquals(0, test.findInterestingRowMember(0));
        assertEquals(1, test.findInterestingRowMember(1));
        assertEquals(3, test.findInterestingRowMember(3));
        assertEquals(11, test.findInterestingRowMember(5));
    }

    @AfterEach
    void tearDown() {
        test = null;
    }
}