/*
 * WaysToCoverInThreeSteps
 */

package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

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
    public void start(ConsoleUtil consoleUtil){
        consoleUtil.printResult(calculateNumberOfWays(consoleUtil.readInt("Enter distance(bigger than 2):")));
    }

    /**
     * Method calculateNumberOfWays includes logic to find solution of task
     *
     * @param number
     * describes distance entered by user
     *
     * @return
     * returns final solution (number of ways)
     */
    int calculateNumberOfWays(int number) {
        if (number < 0) {
            return 0;
        } else if (number == 0) {
            return 1;
        } else if (number == 2) {
            return 2;
        }
        return calculateNumberOfWays(number - 1) + calculateNumberOfWays(number - 2) + calculateNumberOfWays(number - 3);
    }
}
