package inc.softserve.lv_448.java.algo.sorters;

import java.util.Comparator;
import java.util.List;

public class QuickSort<T> extends AbstractSort<T> {

    public QuickSort(){
        super(null);
    }

    public QuickSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void accept(List<T> arr) {
        quicksort(arr, 0, arr.size() - 1);
    }

    private void quicksort(List<T> arr, int l, int r) {
        if (l >= r){
            return;
        }
        int p = partition(arr, l, r);
        quicksort(arr, 0, p - 1);
        quicksort(arr, p + 1, r);
    }

    private int partition(List<T> arr, int l, int r) {
        int m = (l + r)/2;
        T pivot = arr.get(m);
        while (l < r){
            while (compare(arr.get(l), pivot) < 1){
                l++;
            }
            while (compare(arr.get(l), pivot) > 1){
                r--;
            }
            if (l < r){
                T tmp = arr.get(l);
                arr.set(l, arr.get(r));
                arr.set(r, tmp);
            }
        }
        return l;
    }
}