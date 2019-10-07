package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for counting the maximum cost
 * that can be reached withing given amount of days
 * and specified low- and high-effort task costs.
 *
 * @version 1.0
 * created on Oct 3, 2019
 */
public class HighLowEffort implements Startable {

    /**
     * Method starts task flow execution
     */
    @Override
    public void start(ConsoleReader consoleReader) {
        int result = getAmountOfCost(consoleReader.readInt("Please, enter number of days: "),
                consoleReader.readIntegers("Please, enter low-effort task values: "),
                consoleReader.readIntegers("Please, enter high-effort task values: "));
        System.out.println("The result is " + result);
    }

    /**
     * Method counts the maximum amount of cost
     * that can be performed within given number of days.
     *
     * @param numberOfDays    number of days to perform tasks
     * @param lowEffortTasks  low-effort task costs
     * @param highEffortTasks high-effort task costs
     * @return result the maximum amount of cost that can be performed
     */
    int getAmountOfCost(int numberOfDays, List<Integer> lowEffortTasks, List<Integer> highEffortTasks) {
        int result;
        ArrayList<Integer> taskEfforts = new ArrayList<>();

        // Assume that there was no task yesterday
        taskEfforts.add(0);

        // Since there was no task yesterday
        // set high-effort task on day one
        taskEfforts.add(highEffortTasks.get(0));

        for (int i = 2; i <= numberOfDays; i++) {
            taskEfforts.add(i, Math.max(highEffortTasks.get(i - 1) + taskEfforts.get(i - 2),
                    lowEffortTasks.get(i - 1) + taskEfforts.get(i - 1)));
        }

        result = taskEfforts.get(numberOfDays);
        return result;
    }
}
