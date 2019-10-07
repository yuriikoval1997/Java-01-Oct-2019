package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.Arrays;
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
        long result = countWays(consoleUtil.readInt("Please, enter n-value: "),
                consoleUtil.readInt("Please, enter k-value: "));
        consoleUtil.printLongResult(result);
    }

    /**
     * Method counts the number of ways
     * to paint the fence with n number of posts
     * and k number of colors
     *
     * @param n number of posts
     * @param k number of colors
     * @return dp[n] number of ways of painting the fence
     */
    long countWays(int n, int k) {
        // List of results of subproblems
        ArrayList<Long> results = new ArrayList<>(Collections.nCopies(n+1, 0L));

        int mod = 1000000007;

        // There are k ways to color first post
        results.set(1, (long) k);

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        int same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++) {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (int) (results.get(i-1) * (k - 1));
            diff = diff % mod;

            // Total choices till i.
            results.set(i, (long) ((same + diff) % mod));
        }

        return results.get(n);
    }
}
