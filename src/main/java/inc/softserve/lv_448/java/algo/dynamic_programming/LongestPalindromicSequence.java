package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

/**
 * <p>The next class provides functionality for finding the
 * longest palindromic sequence in a string which was
 * entered by a user
 * @author Yuriy Olkhovskyi
 */

public class LongestPalindromicSequence implements Startable {

    /**
     * Main method for getting input, calculating and output of result
     */
    @Override
    public void start(ConsoleUtil consoleUtil) {
        String enteredString = consoleUtil.readString("Please, input your string sequence: ");
        consoleUtil.printResult(findLengthOfTheLongestPalindrome(enteredString));
    }

    /**
     *
     * @param enteredString a string which is entered by a user
     * @return int the length of the longest palindomic sequence
     */
    public int findLengthOfTheLongestPalindrome(String enteredString) {
        if (enteredString.isEmpty()) {
            return 0;
        }

        enteredString = enteredString.toLowerCase();
        String longestPalindrome = enteredString.substring(0, 1);

        for (int i = 0; i < enteredString.length(); i++) {
            String newPalindrome = checkIfEqual(enteredString, i, i);
            if (newPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = newPalindrome;
            }

            newPalindrome = checkIfEqual(enteredString, i, i + 1);
            if (newPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = newPalindrome;
            }
        }

        return longestPalindrome.length();
    }

    /**
     *
     * @param enteredString a string which is entered by a user
     * @param start a start symbol from which comparing is started, it goes left
     *              comparing a correspond element from the right
     * @param end an end symbol from which comparing is started, it goes right
     *      *              comparing a correspond element from the left
     * @return substring which is the longest palindrome from the symbol its started comparing
     */
    private String checkIfEqual(String enteredString, int start, int end) {
        while ((start >= 0 && end < enteredString.length()) && (enteredString.charAt(start) == enteredString.charAt(end))) {
            start--;
            end++;
        }
        return enteredString.substring(start + 1, end);
    }
}
