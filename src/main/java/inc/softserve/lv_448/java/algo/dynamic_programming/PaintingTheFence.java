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

    }

    /**
     * Method counts the maximum amount of cost
     * that can be performed within given number of days.
     *
     * @param n number of posts
     * @param k number of colors
     * @return dp[n] number of ways of painting the fence
     */
    long countWays(int n, int k) {
        // To store results for subproblems
        //long dp[] = new long[n + 1];
        ArrayList<Long> results = new ArrayList<>(Collections.nCopies(n+1, 0L));

        //Arrays.fill(dp, 0);

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
