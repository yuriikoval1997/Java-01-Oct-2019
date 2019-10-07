package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import inc.softserve.lv_448.java.algo.starter.Startable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for sorting arrays of integers using 'Bucket sort' algorithm
 *
 * @author Oleh Kopylchak
 */
public class BucketSort implements Sort, Startable {

    /**
     * Method for sorting arrays of integers using 'Bucket sort' algorithm.
     *
     * @param ints array to sort
     */
    @Override
    public void accept(int[] ints) {
        if (ints.length < 2) {
            return;
        }
        if(Arrays.stream(ints).distinct().count() == 1){
            return;
        }

        List<int[]> buckets = formBuckets(ints);
        buckets.forEach(this);

        int[] sorted = formArray(buckets, ints.length);

        System.arraycopy(sorted, 0, ints, 0, ints.length);
    }

    /**
     * Method that returns number of bucket to put element
     *
     * @param el           element to which must be determined the number of bucket
     * @param bucketAmount bucket amount
     * @param min minimum  element of array
     * @param max maximum  element of array
     * @return int - number of bucket for el
     */
    private int msBits(final int el, final int bucketAmount, long min, long max) {
        return (int) ((el - min) / ((double) (max - min + 1) / bucketAmount));
    }

    /**
     * Method for creating buckets from array
     *
     * @param array array to create buckets
     * @return List<int [ ]> - List with buckets
     */
    private List<int[]> formBuckets(final int[] array) {
        List<List<Integer>> buckets;
        int bucketsNumb;
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        if (array.length < 4) {                             // if array.length < 4 sqrt() = 1 and cause infinity recursion
            bucketsNumb = 2;
        } else {
            bucketsNumb = (int) Math.sqrt(array.length);   // Formula for counting number of buckets
        }

        buckets = Stream.generate((Supplier<ArrayList<Integer>>) ArrayList::new).
                limit(bucketsNumb).
                collect(Collectors.toList());

        List<Integer> currentBucket;
        int bucketIndex;
        for (int i = 0; i < array.length; i++) {
            bucketIndex = msBits(array[i], bucketsNumb, min, max);
            currentBucket = buckets.get(bucketIndex);

            currentBucket.add(array[i]);
        }

        return convertToArrBuckets(buckets);
    }

    /**
     * Method for converting buckets with List of Integers
     * to buckets with arrays of ints
     *
     * @param buckets - buckets to convert
     * @return List<int [ ]> - converted buckets
     */
    private List<int[]> convertToArrBuckets(final List<List<Integer>> buckets) {
        List<int[]> converted = new ArrayList<>();

        for (int i = 0; i < buckets.size(); i++) {
            converted.add(buckets.get(i).stream().mapToInt(a -> a).toArray());
        }

        return converted;
    }

    /**
     * Method for creating array from buckets
     *
     * @param buckets   buckets
     * @param arrLength length of array that will be created
     * @return int[] - array
     */
    private int[] formArray(final List<int[]> buckets, final int arrLength) {
        int[] result = new int[arrLength];
        int offset = 0;

        for (int[] bucket : buckets) {
            System.arraycopy(bucket, 0, result, offset, bucket.length);
            offset += bucket.length;
        }

        return result;
    }
}