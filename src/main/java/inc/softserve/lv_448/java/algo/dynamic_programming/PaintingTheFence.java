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
     * to paint the fence with posts number of posts
     * and colours number of colors
     *
     * @param posts number of posts
     * @param colours number of colours
     * @return results.get(posts) number of ways of painting the fence
     */
    long countWays(int posts, int colours) {
        ArrayList<Long> results = new ArrayList<>(Collections.nCopies(posts+1, 0L));

        int mod = 1000000007;

        results.set(1, (long) colours);

        int same = 0, diff = colours;

        for (int i = 2; i <= posts; i++) {
            same = diff;

            diff = (int) (results.get(i-1) * (colours - 1));
            diff = diff % mod;

            results.set(i, (long) ((same + diff) % mod));
        }

        return results.get(posts);
    }
}
