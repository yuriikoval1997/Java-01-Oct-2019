package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingSort implements Sort {

    @Override
    public void accept(int[] ints) {
        if (ints.length < 2) {
            return;
        }

        int min = Arrays.stream(ints).min().getAsInt();
        int max = Arrays.stream(ints).max().getAsInt();

        if(min < 0){
            throw new IllegalArgumentException("The input numbers should be greater then 0");
        }

        List<Integer> filledWithIndexes = getFilledWithElCount(ints, min, max);
        fillWithIndexes(filledWithIndexes);

        int[] sorted = getSorted(filledWithIndexes, ints, min);

        System.arraycopy(sorted, 0, ints, 0, ints.length);
    }

    private int[] getSorted(List<Integer> filledWithIndexes, int[] array, int minEl) {
        int[] sorted = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sorted[filledWithIndexes.get(array[i] - minEl) - 1] = array[i];
            filledWithIndexes.set(array[i] - minEl, filledWithIndexes.get(array[i] - minEl) - 1);
        }

        return sorted;
    }

    private void fillWithIndexes(List<Integer> filledWithElCount) {
        for (int i = 1; i < filledWithElCount.size(); i++) {
            filledWithElCount.set(i, filledWithElCount.get(i) + filledWithElCount.get(i - 1));
        }
    }

    private List<Integer> getFilledWithElCount(int[] source, int minEl, int maxEl) {
        List<Integer> filledWithElCount = Stream.generate(() -> 0).limit(maxEl - minEl + 1).collect(Collectors.toList());

        for(int el : source){
            filledWithElCount.set(el - minEl, filledWithElCount.get(el - minEl) + 1);
        }

        return filledWithElCount;
    }

}
