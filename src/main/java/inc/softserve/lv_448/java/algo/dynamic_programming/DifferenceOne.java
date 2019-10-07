package inc.softserve.lv_448.java.algo.dynamic_programming;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.List;

public class DifferenceOne implements Startable {

    @Override
    public void start(ConsoleUtil consoleUtil) {
    }

    public static int longestSubSeq(List<Integer> seq){
        int max = 0;
        int count = 1;
        for (int i = 0; i < seq.size() - 1; i++) {
            if (Math.abs(seq.get(i) - seq.get(i + 1)) == 1){
                count++;
            } else {
                if (count > max){
                    max = count;
                }
                count = 1;
            }
        }
        if (count > max){
            max = count;
        }
        return max;
    }
}
