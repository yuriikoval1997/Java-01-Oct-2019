package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for counting the number of ways
 * to paint the fence such that at most 2
 * adjacent posts have the same color
 *
 * @version 1.0
 * created on Oct 7, 2019
 */
public class PaintingTheFence implements Startable {

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
     * and k number of colors
     *
     * @param n number of posts
     * @param k number of colors
     * @return results.get(n) number of ways of painting the fence
     */
    long countWays(int n, int k) {
        ArrayList<Long> results = new ArrayList<>(Collections.nCopies(n+1, 0L));

        int mod = 1000000007;

        results.set(1, (long) k);

        int same = 0, diff = k;

        for (int i = 2; i <= n; i++) {

            same = diff;

            diff = (int) (results.get(i-1) * (k - 1));
            diff = diff % mod;

            results.set(i, (long) ((same + diff) % mod));
        }

        return results.get(n);
    }
}
