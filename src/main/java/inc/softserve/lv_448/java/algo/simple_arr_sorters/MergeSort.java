package inc.softserve.lv_448.java.algo.simple_arr_sorters;

public class MergeSort implements Sort {

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