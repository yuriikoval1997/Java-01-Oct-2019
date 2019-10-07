/*
 * WaysToCoverInThreeSteps
 */

package inc.softserve.lv_448.java.algo.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class solving task called "Ways to cover in three steps"
 *
 * Explanation: Given a distance, count total number of ways to cover the distance with 1, 2 and 3 steps.
 *
 * @version 1.0 from 4.06.19
 * @author Max Hrynkiv
 *
 */
public class WaysToCoverInThreeSteps /*extends Startable*/{

    /**
     * Method "start" runs our application
     */
    public void start() {
        System.out.println("There is " + calculateNumberOfWays(read()) + " ways to cover distance.");
    }

    /**
     * Method calculateNumberOfWays includes logic to find solution of task
     *
     * @param n
     * describes distance entered by user
     *
     * @return
     * returns final solution (number of ways)
     */
    public int calculateNumberOfWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return calculateNumberOfWays(n - 1) + calculateNumberOfWays(n - 2) + calculateNumberOfWays(n - 3);
    }

    /**
     * Method read reads data from console, entered by user
     *
     * @return
     * returns entered number
     */
    public int read() {
        int input = 0;
        System.out.print("Enter distance(bigger than 2):");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Entered number should be int-type");
            start();
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Something went wrong...");
            }
        }
        return input;
    }
}
