package inc.softserve.lv_448.java.algo.starter;

import inc.softserve.lv_448.java.algo.simple_arr_sorters.InsertionSort;
import inc.softserve.lv_448.java.algo.simple_arr_sorters.MergeSort;
import inc.softserve.lv_448.java.algo.simple_arr_sorters.QuickSort;
import inc.softserve.lv_448.java.algo.simple_arr_sorters.Sort;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

import java.util.stream.IntStream;

class Sorter {

    static void input(ConsoleReader consoleReader){
        showOptions();
        String command;
        Sort sort = new MergeSort();
        label:
        do {
            command = consoleReader.readString();
            switch (command) {
                case "1":
                    sort = new MergeSort();
                    break label;
                case "2":
                    sort = new QuickSort();
                    break label;
                case "3":
                    sort = new InsertionSort();
                    break label;
                case "4":
                    //todo - count sort
                    break label;
                case "5":
                    //todo - bucket sort
                    break label;
                default:
                    System.out.println("There is no such an option! Try again.");
                    break;
            }
        } while (true);
        int[] integers = consoleReader.readIntegers().stream()
                .mapToInt(x -> x)
                .toArray();
        sort.accept(integers);
        IntStream.of(integers).forEach(x -> System.out.print(x + " "));
    }

    private static void showOptions(){
        System.out.println("Choose sort algorithm:\n"
                + "1 = merge sort\n"
                + "2 = quick sort\n"
                + "3 = insertion sort\n"
                + "4 = count sort\n"
                + "5 = bucket sort\n"
        );
    }
}
