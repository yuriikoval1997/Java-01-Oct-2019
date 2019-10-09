package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

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
    public void start(ConsoleUtil consoleUtil) {
        int numberOfDays = consoleUtil.readInt("Please, enter number of days: ");
        System.out.println("Low Effort Tasks");
        List<Integer> lowEffortTasks = validateInputArray(consoleUtil, numberOfDays);
        System.out.println("High Effort Tasks");
        List<Integer> highEffortTasks = validateInputArray(consoleUtil, numberOfDays);
        int result = getAmountOfCost(numberOfDays, lowEffortTasks, highEffortTasks);
        consoleUtil.printResult(result);
    }

    /**
     * Method validates that number task costs
     * entered by user is equal to number of days.
     *
     * @param consoleUtil utils to retrieve user input
     * @param numberOfDays number of days to compare with input array size
     * @return input array with correct amount of task costs
     */
    private List<Integer> validateInputArray(ConsoleUtil consoleUtil, int numberOfDays) {
        boolean isValid = false;
        List<Integer> input = null;
        while (!isValid) {
            input = consoleUtil.readIntegers("Please, enter task costs ("
                            + numberOfDays +" space separated integers): ");
            if(input.size() == numberOfDays) {
                isValid = true;
            } else {
                System.out.println("You've entered wrong number of task costs");
            }
        }
        return input;
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

        if(numberOfDays < 1) {
            return 0;
        }

        if(numberOfDays == 1) {
            return highEffortTasks.get(0);
        }

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
