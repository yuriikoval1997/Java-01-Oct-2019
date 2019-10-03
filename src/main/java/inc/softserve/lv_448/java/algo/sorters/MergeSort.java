package inc.softserve.lv_448.java.algo.sorters;

import java.util.Arrays;

public class MergeSort implements Sort {

    public static void main(String[] args) {
        Sort mergeSort = new MergeSort();
        int[] x = new int[]{64, 34, 25, 12, 22, 11, 90, 87};
        mergeSort.accept(x);
        System.out.println(Arrays.toString(x));

        int[] y = new int[]{64, 34, 25, 12, 22, 11, 90, 87, 25};
        mergeSort.accept(y);
        System.out.println(Arrays.toString(y));
    }

    @Override
    public void accept(int[] arr) {
        divide(arr);
    }

    private void divide(int[] arr){
        if (arr.length <= 1){
            return;
        }
        int m = arr.length / 2;
        int[] left = new int[m];
        int[] right = new int[arr.length - m];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, m, right, 0, right.length);
        divide(left);
        divide(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] common){
        int l = 0;
        int r = 0;
        int c = 0;
        while (l < left.length && r < right.length){
            if (left[l] < right[r]){
                common[c] = left[l];
                c++;
                l++;
            } else {
                common[c] = right[r];
                c++;
                r++;
            }
        }
        while (l < left.length){
            common[c++] = left[l++];
        }
        while (r < right.length){
            common[c++] = right[r++];
        }
    }
}