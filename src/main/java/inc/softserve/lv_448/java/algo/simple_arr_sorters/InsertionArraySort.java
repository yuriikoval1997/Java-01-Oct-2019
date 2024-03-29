package inc.softserve.lv_448.java.algo.simple_arr_sorters;

public class InsertionArraySort implements ArraySort {

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
}
