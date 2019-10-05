package inc.softserve.lv_448.java.algo.dynamic_programming;

import java.util.List;

public class DifferenceOne {

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
