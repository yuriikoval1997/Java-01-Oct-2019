package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.*;

/**
 * Class for sorting arrays of integers using 'Bucket sort' algorithm
 *
 * @author Oleh Kopylchak
 */
public class BucketSort implements Sort {

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

        Map<Integer, int[]> buckets = formBuckets(ints);
        buckets.values().forEach(this);

        int[] sorted = formArray(buckets, ints.length);

        System.arraycopy(sorted, 0, ints, 0, ints.length);
    }

    /**
     * Method that returns number of bucket to put element
     *
     * @param array array to sort
     * @param el element to which must be determined the number of bucket
     * @param bucketAmount bucket amount
     *
     * @return int - number of bucket for el
     */
    private int msBits(final int[] array, final int el, final int bucketAmount) {
        long max = Arrays.stream(array).max().getAsInt();
        long min = Arrays.stream(array).min().getAsInt();

        return (int) ((el - min) / ((double) (max - min + 1) / bucketAmount));
    }

    /**
     * Method for creating buckets from array
     *
     * @param array array to create buckets
     * @return Map<Integer, int[]> - map, that is bucket
     */
    private Map<Integer, int[]> formBuckets(final int[] array) {
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        int bucketsNumb;

        if (array.length < 4) {                             // if array.length < 4 sqrt() = 1 and cause infinity recursion
            bucketsNumb = 2;
        } else {
            bucketsNumb = (int) Math.sqrt(array.length);   // Formula for counting number of buckets
        }

        List<Integer> currentBucket;
        int offset;
        for (int i = 0; i < array.length; i++) {
            offset = msBits(array, array[i], bucketsNumb);
            currentBucket = buckets.get(offset);

            if (currentBucket != null) {
                currentBucket.add(array[i]);
            } else {
                buckets.put(offset, new ArrayList<>(Collections.singletonList(array[i])));
            }
        }

        return convertToArrBuckets(buckets);
    }

    /**
     * Method for converting buckets with List of integers
     * to buckets with arrays of int
     *
     * @param buckets - buckets to convert
     * @return Map<Integer, int[]> - converted buckets
     */
    private Map<Integer, int[]> convertToArrBuckets(final Map<Integer, List<Integer>> buckets) {
        Map<Integer, int[]> converted = new LinkedHashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : buckets.entrySet()) {
            converted.put(entry.getKey(), entry.getValue().stream().mapToInt(a -> a).toArray());
        }

        return converted;
    }

    /**
     * Method for creating array from buckets
     *
     * @param buckets buckets
     * @param arrLength length of array that will be created
     * @return int[] - array
     */
    private int[] formArray(final Map<Integer, int[]> buckets, final int arrLength) {
        int[] result = new int[arrLength];
        int offset = 0;

        for (int[] bucket : buckets.values()) {
            System.arraycopy(bucket, 0, result, offset, bucket.length);
            offset += bucket.length;
        }

        return result;
    }
}