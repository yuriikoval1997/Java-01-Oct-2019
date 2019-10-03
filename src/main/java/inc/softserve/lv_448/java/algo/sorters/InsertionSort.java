package inc.softserve.lv_448.java.algo.sorters;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class InsertionSort<T> extends Sort<T> {

    public InsertionSort(){
        super(null);
    }

    public InsertionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void accept(List<T> arr) {
        for (int i = 1; i < arr.size(); i++) {
            T key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && compare(arr.get(j), key) > 0){
                arr.set(j+1, arr.get(j));
                j--;
            }
            arr.set(j+1, key);
        }
    }
}
