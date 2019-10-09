package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.List;
import java.util.function.Consumer;

/**
 * Accepts an integer array and sorts it in place.
 */
@FunctionalInterface
public interface Sort extends Consumer<int[]>, Startable {

    @Override
    default void start(ConsoleUtil consoleUtil) {
        List<Integer> list = consoleUtil.readIntegers("Please, enter space separated integers to sort");
        int[] ints = list.stream()
                .mapToInt(x -> x)
                .toArray();
        accept(ints);
        consoleUtil.printResult(ints);
    }
}
