package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * Class for counting the number of ways
 * to paint the fence such that at most 2
 * adjacent posts have the same color
 * in optimized way using one variable
 *
 * @version 1.0
 * created on Oct 7, 2019
 */
public class PaintingTheFenceOptimized implements Startable {

    /**
     * Method starts task flow execution
     */
    @Override
    public void start(ConsoleUtil consoleUtil) {
        long result = countWays(consoleUtil.readInt("Please, enter number of posts (n): "),
                consoleUtil.readInt("Please, enter number of colors (k): "));
        consoleUtil.printLongResult(result);
    }

    /**
     * Method counts the number of ways
     * to paint the fence with posts number of posts
     * and colours number of colors in optimized way
     * using one variable
     *
     * @param posts number of posts
     * @param colours number of colours
     * @return total number of ways of painting the fence
     */
    long countWays(int posts, int colours) {
        long total = colours;
        int mod = 1000000007;

        int same = 0, diff = colours;

        for (int i = 2; i <= posts; i++) {
            same = diff;

            diff = (int) total * (colours - 1);
            diff = diff % mod;

            total = (same + diff) % mod;
        }
        return total;
    }
}