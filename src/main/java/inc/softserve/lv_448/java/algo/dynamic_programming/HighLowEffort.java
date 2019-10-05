package inc.softserve.lv_448.java.algo.dynamic_programming;

public class HighLowEffort {

    public static int maxEffort(int[] low, int[] high, int days){
        int[] lookup = new int[days+1];
        lookup[0] = 0;
        lookup[1] = high[0];
        for (int i = 2; i <= days; i++) {
            lookup[i] = Math.max(lookup[i-1] + low[i-1], lookup[i-2] + high[i-1]);
        }
        return lookup[days];
    }
}
