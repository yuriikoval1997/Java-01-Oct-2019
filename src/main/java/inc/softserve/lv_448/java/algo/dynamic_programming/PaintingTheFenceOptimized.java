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
     * to paint the fence with n number of posts
     * and k number of colors in optimized way
     * using one variable
     *
     * @param n number of posts
     * @param k number of colors
     * @return total number of ways of painting the fence
     */
    long countWays(int n, int k) {
        long total = k;
        int mod = 1000000007;

        int same = 0, diff = k;

        for (int i = 2; i <= n; i++) {
            same = diff;

            diff = (int) total * (k - 1);
            diff = diff % mod;

            total = (same + diff) % mod;
        }
        return total;
    }
}