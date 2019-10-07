package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

public class LongestPalindromicSequence implements Startable {

    @Override
    public void start(ConsoleUtil consoleUtil) {
        String enteredString = consoleUtil.readString("Please, input your string sequence: ");
        System.out.println("Output: " + findLengthOfTheLongestPalindrome(enteredString));
    }

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

    private String checkIfEqual(String enteredString, int start, int end) {
        while ((start >= 0 && end < enteredString.length()) && (enteredString.charAt(start) == enteredString.charAt(end))) {
            start--;
            end++;
        }
        return enteredString.substring(start + 1, end);
    }
}
