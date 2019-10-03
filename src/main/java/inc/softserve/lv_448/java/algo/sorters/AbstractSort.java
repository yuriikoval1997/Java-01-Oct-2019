package inc.softserve.lv_448.java.algo.sorters;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractSort<T> implements Sort<T> {
    protected final Comparator<T> comparator;

    protected AbstractSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    protected int compare(T t1, T t2){
        if (this.comparator == null){
            return ((Comparable) t1).compareTo(t2);
        }
        return comparator.compare(t1, t2);
    }
}
