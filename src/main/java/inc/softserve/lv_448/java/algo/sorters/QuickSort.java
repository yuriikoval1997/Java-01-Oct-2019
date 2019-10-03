package inc.softserve.lv_448.java.algo.sorters;

import java.util.Arrays;

public class QuickSort implements Sort {

    public static void main(String[] args) {
        Sort qu = new QuickSort();
        int[] x = new int[]{64, 34, 25, 12, 22, 11, 90, 87};
        qu.accept(x);
        System.out.println(Arrays.toString(x));
    }

    @Override
    public void accept(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int p = partition(arr, l, r);
        quicksort(arr, 0, p - 1);
        quicksort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int m = (l + r)/2;
        int pivot = arr[m];
        while (l < r){
            while (arr[l] < pivot){
                l++;
            }
            while (arr[r] > pivot){
                r--;
            }
            if (l < r){
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        return l;
    }
}