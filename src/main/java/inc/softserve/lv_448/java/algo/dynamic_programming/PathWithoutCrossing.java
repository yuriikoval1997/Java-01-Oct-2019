package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

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
    public void start(ConsoleReader consoleReader){
        System.out.println("Your result is: " + calculate(consoleReader.readInt("Enter even number")));
    }

    /**
     * Method for calculating the number of ways.
     *
     * @param pointCount The number of points.
     * @return The number of ways to connect point without crossing.
     */
    public int calculate(int pointCount){
        if (pointCount % 2 != 0 || pointCount < 1) {
            return pointCount = 0;
        }
        pointCount = pointCount / 2;
        int subproblemRes[] = new int [pointCount + 1];
        subproblemRes[0] = subproblemRes[1] = 1;
        for (int i = 2; i <= pointCount; i++) {
            subproblemRes[i] = 0;
            for (int j = 0; j < i; j++) {
                subproblemRes[i] += subproblemRes[j] * subproblemRes[i - j - 1];
            }
        }
        return subproblemRes[pointCount];
    }
}
