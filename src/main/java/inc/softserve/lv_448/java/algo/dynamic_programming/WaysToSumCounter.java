package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

import java.util.List;

/**
 * Class for counting the number of ways to
 * sum to N using given integers
 *
 * @author Oleh Kopylchak
 */
public class WaysToSumCounter implements Startable {

    /**
     * Method, that starts counting
     *
     * @param consoleReader object for console input reading
     */
    @Override
    public void start(ConsoleReader consoleReader) {
        try {
            List<Integer> possibleNumbers = consoleReader.readIntegers("Please, enter possible numbers: ");
            int n = consoleReader.readInt("Please enter N: ");
            long result = countWaysToSumToN(possibleNumbers, n);

            System.out.println("Number of ways to sum to " + n + " is: " + result);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that count ways to sum to n
     *
     * @param possibleNumbers list of numbers that can be used to sum to n
     * @param n               number that must be summed using possibleNumbers
     * @return long - ways to sum to n
     * @throws IllegalArgumentException method throws exception when n or one of possibleNumbers
     *                                  are not natural. That's because there can be infinity ways to sum to n using zero or
     *                                  negative numbers
     */
    public long countWaysToSumToN(List<Integer> possibleNumbers, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number can only be natural.");
        }
        if (possibleNumbers.stream().anyMatch(a -> a < 1)) {
            throw new IllegalArgumentException("There are not natural numbers in possible numbers. "
                    + "Number of solutions is infinity.");
        }

        int[] count = new int[n + 1];

        count[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < possibleNumbers.size(); j++) {

                if (i >= possibleNumbers.get(j)) {
                    count[i] += count[i - possibleNumbers.get(j)];
                }

            }
        }

        return count[n];
    }
}