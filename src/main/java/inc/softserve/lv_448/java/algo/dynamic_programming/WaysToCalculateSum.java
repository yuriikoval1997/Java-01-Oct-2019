package inc.softserve.lv_448.java.algo.dynamic_programming;

/**
 * That class calculates all possible ways to write n
 * as sum of two or more positive integers.
 */

public class WaysToCalculateSum {

    /**
     * Performs main calculations.
     * All variants are stored in an array.
     * If user's number is 0 - array is initialized with default value 1.
     * The loop iterates all integer one by one and update the count[] values
     * after the index greater than or equal to n
     *
     * @param userNumber value entered by user
     * @return maximum combinations of users's number partitions.
     */
    public static int calculateWays(int userNumber) {
        if (userNumber < 0) {
            throw new IllegalArgumentException("Number can be only natural.");
        }
        int[] array = new int[userNumber + 1];
        array[0] = 1;
        for (int i = 1; i < userNumber; i++) {
            for (int j = i; j <= userNumber; j++) {
                array[j] += array[j - i];
            }
        }
        return array[userNumber];
    }

}
