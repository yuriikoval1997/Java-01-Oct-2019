package inc.softserve.lv_448.java.algo.dynamic_programming.sequences;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.List;
import java.util.function.IntFunction;

@FunctionalInterface
public interface SeqGenerator extends IntFunction<List<Integer>>, Startable {

    /**
     * Generates a sequence of integers.
     * @param number - end of the sequence, inclusive
     * @return sequence of integers.
     */
    @Override
    List<Integer> apply(int number);

    @Override
    default void start(ConsoleUtil consoleUtil) {
        int n = consoleUtil.readInt("Enter an integer: ");
        int result = apply(n)
                .stream()
                .skip(n)
                .findFirst()
                .orElse(0);
        consoleUtil.printResult(result);
    }
}
