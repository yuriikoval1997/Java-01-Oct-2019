package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for sorting arrays of integers using 'Counting sort' algorithm
 *
 * @author Oleh Kopylchak
 */
public class CountingSort implements Sort, Startable {

    /**
     * Method, that starts sorting
     *
     * @param consoleUtil object for console input reading
     */
    @Override
    public void start(ConsoleUtil consoleUtil) {
        try {
            int[] array = consoleUtil.readIntegers("Please, enter array elements: ").
                    stream().mapToInt(a -> a).toArray();
            accept(array);

            System.out.println("Sorted array: \n" + Arrays.toString(array));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method for sorting array of integers
     *
     * @exception IllegalArgumentException throw when there is negative element in array.
     * This method can only sort arrays with positive ints;
     * @param ints array that must be sorted
     */
    @Override
    public void accept(int[] ints) {
        if (ints.length < 2) {
            return;
        }

        int min = Arrays.stream(ints).min().getAsInt();
        int max = Arrays.stream(ints).max().getAsInt();

        if (min < 0) {
            throw new IllegalArgumentException("The input numbers should be greater then 0");
        }

        List<Integer> filledWithIndexes = getFilledWithElCount(ints, min, max);
        fillWithIndexes(filledWithIndexes);

        int[] sorted = getSorted(filledWithIndexes, ints, min);

        System.arraycopy(sorted, 0, ints, 0, ints.length);
    }

    /**
     * Method for sorting array using list with indexes of array elements
     *
     * @param filledWithIndexes list filled with indexes of array elements
     * @param array             method returns sorted copy of this array
     * @param minEl             minimum element of array to sort
     * @return int[] - sorted copy of array
     */
    private int[] getSorted(List<Integer> filledWithIndexes, final int[] array, final int minEl) {
        int[] sorted = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sorted[filledWithIndexes.get(array[i] - minEl) - 1] = array[i];
            filledWithIndexes.set(array[i] - minEl, filledWithIndexes.get(array[i] - minEl) - 1);
        }

        return sorted;
    }

    /**
     * Method that fills list with indexes of array element. Every index
     * determines position of element in sorted array
     *
     * @param filledWithElCount list with numbers of repetitions of
     *                          every element from array
     */
    private void fillWithIndexes(List<Integer> filledWithElCount) {
        for (int i = 1; i < filledWithElCount.size(); i++) {
            filledWithElCount.set(i, filledWithElCount.get(i) + filledWithElCount.get(i - 1));
        }
    }

    /**
     * Method for counting numbers of repetitions of each element
     * in array
     *
     * @param source array to count numbers of repetitions
     * @param minEl  minimum element of array
     * @param maxEl  maximum element of array
     * @return List<Integer> - contains numbers of repetition
     * of each element
     */
    private List<Integer> getFilledWithElCount(int[] source, int minEl, int maxEl) {
        List<Integer> filledWithElCount = Stream.generate(() -> 0).limit(maxEl - minEl + 1).collect(Collectors.toList());

        for (int el : source) {
            filledWithElCount.set(el - minEl, filledWithElCount.get(el - minEl) + 1);
        }

        return filledWithElCount;
    }
}
