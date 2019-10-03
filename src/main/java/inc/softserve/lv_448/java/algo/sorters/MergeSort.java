package inc.softserve.lv_448.java.algo.sorters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class MergeSort<T> extends Sort<T> {

    public MergeSort() {
        super(null);
    }

    public MergeSort(Comparator<T> comparator){
        super(comparator);
    }

    @Override
    public void accept(List<T> arr) {
        divide(arr);
    }

    private void divide(List<T> arr){
        if (arr.size() <= 1){
            return;
        }
        int m = arr.size() / 2;
        List<T> left = new ArrayList<>(arr.subList(0, m));
        List<T> right = new ArrayList<>(arr.subList(m, arr.size()));
        divide(left);
        divide(right);
        merge(left, right, arr);
    }

    private void merge(List<T> left, List<T> right, List<T> common){
        int l = 0;
        int r = 0;
        int c = 0;
        while (l < left.size() && r < right.size()){
            if (compare(left.get(l), right.get(r)) < 0){
                common.set(c, left.get(l));
                c++;
                l++;
            } else {
                common.set(c, right.get(r));
                c++;
                r++;
            }
        }
        while (l < left.size()){
            common.set(c++, left.get(l++));
        }
        while (r < right.size()){
            common.set(c++, right.get(r++));
        }
    }
}