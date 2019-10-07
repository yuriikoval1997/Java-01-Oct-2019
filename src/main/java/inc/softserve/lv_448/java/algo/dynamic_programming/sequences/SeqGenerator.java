package inc.softserve.lv_448.java.algo.dynamic_programming.sequences;

import java.util.List;
import java.util.function.IntFunction;

@FunctionalInterface
public interface SeqGenerator extends IntFunction<List<Integer>> {

    /**
     * Generates a sequence of integers.
     * @param number - end of the sequence, inclusive
     * @return sequence of integers.
     */
    @Override
    List<Integer> apply(int number);
}
