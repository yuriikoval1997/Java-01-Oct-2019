package inc.softserve.lv_448.java.algo.dynamic_programming;

/**
 * Class for counting possible
 * ways to tile the n x m floor
 *
 * @version 1.0
 * created on Oct 7, 2019
 */
public class WaysToTileTheFloor {
    /**
     * Method counts possible ways to tile the n x m floor
     * using 1 x m tiles
     *
     * @param n n-dimension of the floor
     * @param m m-dimension of the floor
     * @return count[n] number of ways to tile the floor
     */
    public int countWays(int n, int m) {
        // table to store values
        // of subproblems
        int count[] = new int[n + 1];
        count[0] = 0;

        // Fill the table upto value n
        int i;
        for (i = 1; i <= n; i++) {
            // recurrence relation
            if (i > m) {
                count[i] = count[i - 1] + count[i - m];
            } else if (i < m) {
                // base cases
                count[i] = 1;
            } else {
                // i = = m
                count[i] = 2;
            }
        }

        // required number of ways
        return count[n];
    }
}
