package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * Class for calculation non-crossing lines to connect points in a circle.
 *
 * @author Volodymyr Turko
 */
public class PathWithoutCrossing implements Startable {

    /**
     * Main method for getting input, calculating and output of result.
     */
    @Override
    public void start(ConsoleUtil consoleUtil){
        consoleUtil.printResult(calculate(consoleUtil.readInt("Enter even number")));
    }

    /**
     * Method for calculating the number of ways.
     *
     * @param pointCount The number of points.
     * @return The number of ways to connect point without crossing.
     */
    int calculate(int pointCount){
        if (pointCount % 2 != 0 || pointCount < 1) {
            return 0;
        }
        pointCount = pointCount / 2;
        int[] pathCount = new int[pointCount + 1];
        pathCount[0] = 1;
        pathCount[1] = 1;
        for (int i = 2; i <= pointCount; i++) {
            for (int j = 0; j < i; j++) {
                pathCount[i] += pathCount[j] * pathCount[i - j - 1];
            }
        }
        return pathCount[pointCount];
    }
}
