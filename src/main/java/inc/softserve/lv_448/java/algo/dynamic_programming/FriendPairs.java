package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * Class find out the total number of ways in which friends can remain single or can be paired up
 */
public class FriendPairs implements Startable {

  /**
   * Main method for getting input, calculating and output of result
   */
  @Override
  public void start(ConsoleUtil consoleUtil) {
    consoleUtil.printResult(checkValidInputNumbers(consoleUtil.readInt("Please fill in count of friends")));
  }

  /**
   * Method find out the total number of ways in which friends can remain single or can be paired
   * up
   *
   * @param count Number of friends
   * @return long - Number of ways in which friends can remain single or can be paired up
   */
  int countFriendsPairings(int count) {
    int[] array = new int[count + 1];
    for (int i = 0; i <= count; i++) {
      if (i <= 2) {
        array[i] = i;
      } else {
        array[i] = array[i - 1] + (i - 1) * array[i - 2];
      }
    }
    return array[count];
  }

  /**
   * Method returns number if it is valid. Else return 0
   *
   * @return int - valid number
   */
  private int checkValidInputNumbers(int inputData) {
    if (inputData > 0) {
      return countFriendsPairings(inputData);
    } else {
      return 0;
    }
  }

}

