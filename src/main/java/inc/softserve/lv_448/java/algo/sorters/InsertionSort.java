package inc.softserve.lv_448.java.algo.sorters;

import java.util.Arrays;

public class InsertionSort implements Sort {

    @Override
    public void accept(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{64, 34, 25, 12, 22, 11, 90, 87};
        Sort sort = new InsertionSort();
        sort.accept(x);
        System.out.println(Arrays.toString(x));
    }
}
