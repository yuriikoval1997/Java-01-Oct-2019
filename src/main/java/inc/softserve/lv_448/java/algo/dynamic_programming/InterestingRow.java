package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * That class find which is the member of position input integer
 * in our interesting row
 */
public class InterestingRow implements Startable {

    /**
     * Method starts task flow execution
     */
    @Override
    public void start(ConsoleUtil consoleUtil) {
        consoleUtil.printResult(findInterestingRowMember(consoleUtil
                .readInt("Please enter position member of integers row: ")));
    }

    /**
     * Performs main calculations.
     * Makes interesting row of integers array and find
     * positions member in row of input userNumber
     *
     * @param userNumber value entered by user
     * @return number in array at position userNumber.
     */
    int findInterestingRowMember(int userNumber) {

        if (userNumber < 1) {
            return 0;
        }
        int[] interestingRowArray = new int[userNumber + 2];
        interestingRowArray[1] = 1;
        interestingRowArray[2] = 1;
        for (int i = 3; i <= userNumber; i++) {
            interestingRowArray[i] = 2 * interestingRowArray[i - 2] + interestingRowArray[i - 1];
        }
        return interestingRowArray[userNumber];
    }

}
