/*
 * WaysToCoverInThreeSteps
 */

package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

/**
 * This class solving task called "Ways to cover in three steps"
 *
 * Explanation: Given a distance, count total number of ways to cover the distance with 1, 2 and 3 steps.
 *
 * @version 1.0 from 4.06.19
 * @author Max Hrynkiv
 *
 */
public class WaysToCoverInThreeSteps implements Startable{

    /**
     * Method "start" runs our application
     */
    @Override
    public void start(ConsoleReader consoleReader){
        System.out.println("There is " + calculateNumberOfWays(consoleReader.readInt("Enter distance(bigger than 2):")) + " ways to cover distance.");
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
}
