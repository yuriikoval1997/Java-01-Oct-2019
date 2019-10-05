package inc.softserve.lv_448.java.algo.dynamic_programming;

import java.util.List;

public class WaysToSumCounter {
    public long countWaysToSumToN(List<Integer> possibleNumbers, int n){
        if (n < 1) {
            throw new IllegalArgumentException("Number can only be natural.");
        }
        if(possibleNumbers.stream().anyMatch(a -> a < 1)){
            throw new IllegalArgumentException("There are not natural numbers in possible numbers. Number of solutions is infinity.");
        }

        int[] count = new int[n + 1];

        count[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < possibleNumbers.size(); j++) {

                if (i >= possibleNumbers.get(j)) {
                    count[i] += count[i - possibleNumbers.get(j)];
                }

            }
        }

        return count[n];
    }
}