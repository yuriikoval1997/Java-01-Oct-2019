package inc.softserve.lv_448.java.algo.dynamic_programming;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSequenceTest {
    private LongestPalindromicSequence longestPalindromicSequence;

    @BeforeEach
    void init(){
        longestPalindromicSequence = new LongestPalindromicSequence();
    }



    @Test
    void longestPalindromeTest1() {
        int expected = 5;
        int actual = longestPalindromicSequence.findLengthOfTheLongestPalindrome("bananas");
        assertEquals(expected, actual);
    }

    @Test
    void longestPalindromeTest2() {
        int expected = 3;
        int actual = longestPalindromicSequence.findLengthOfTheLongestPalindrome("mom");
        assertEquals(expected, actual);
    }

    @Test
    void longestPalindromeTest3() {
        int expected = 0;
        int actual = longestPalindromicSequence.findLengthOfTheLongestPalindrome("");
        assertEquals(expected, actual);
    }

    @Test
    void longestPalindromeTest4() {
        int expected = 1;
        int actual = longestPalindromicSequence.findLengthOfTheLongestPalindrome("zxcvbnm");
        assertEquals(expected, actual);
    }

    @Test
    void longestPalindromeTest5() {
        int expected = 7;
        int actual = longestPalindromicSequence.findLengthOfTheLongestPalindrome("DeiFIeD palindromeD");
        assertEquals(expected, actual);
    }

}