package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * Class for counting possible
 * ways to tile the n x m floor
 *
 * @version 1.0
 * created on Oct 7, 2019
 */
public class WaysToTileTheFloor implements Startable {

    /**
     * Method starts task flow execution
     */
    @Override
    public void start(ConsoleUtil consoleUtil) {
        int result = countWays(consoleUtil.readInt("Please, enter n-dimension of the floor: "),
               consoleUtil.readInt("Please, enter m-dimension of the floor: "));
        consoleUtil.printResult(result);
    }

    /**
     * Method counts possible ways to tile the n x m floor
     * using 1 x m tiles
     *
     * @param n n-dimension of the floor
     * @param m m-dimension of the floor
     * @return count[n] number of ways to tile the floor
     */
    int countWays(int n, int m) {

        int[] count = new int[n + 1];
        count[0] = 0;

        // Fill the table upto value n
        for (int i = 1; i <= n; i++) {
            if (i > m) {
                count[i] = count[i - 1] + count[i - m];
            } else if (i < m) {
                count[i] = 1;
            } else {
                count[i] = 2;
            }
        }

        return count[n];
    }

}
