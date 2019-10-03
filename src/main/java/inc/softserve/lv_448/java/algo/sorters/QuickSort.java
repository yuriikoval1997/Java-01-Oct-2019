package inc.softserve.lv_448.java.algo.sorters;

public class QuickSort implements Sort {

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