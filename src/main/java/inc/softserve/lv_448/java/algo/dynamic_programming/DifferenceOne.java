package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.List;

public class DifferenceOne implements Startable {

    @Override
    public void start(ConsoleUtil consoleUtil) {
        consoleUtil.printResult(longestSubSeq(
                consoleUtil.readIntegers("Please, enter space separated numbers")));
    }

    private static int longestSubSeq(List<Integer> seq){
        int maxLength = 0;
        int count = 1;
        for (int i = 0; i < seq.size() - 1; i++) {
            if (Math.abs(seq.get(i) - seq.get(i + 1)) == 1){
                count++;
            } else {
                if (count > maxLength){
                    maxLength = count;
                }
                count = 1;
            }
        }
        if (count > maxLength){
            maxLength = count;
        }
        return maxLength;
    }
}
