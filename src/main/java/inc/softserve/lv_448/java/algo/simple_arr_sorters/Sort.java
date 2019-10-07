package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public interface Sort extends Consumer<int[]>, Startable {

    @Override
    default void start(ConsoleReader consoleReader) {
        List<Integer> list = consoleReader.readIntegers("Please, enter space separated integers to sort");
        int[] ints = list.stream()
                .mapToInt(x -> x)
                .toArray();
        accept(ints);
        System.out.println("The sorted array is: " + Arrays.toString(ints));
    }
}
