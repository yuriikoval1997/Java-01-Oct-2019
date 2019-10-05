package inc.softserve.lv_448.java.algo.simple_arr_sorters;

import java.util.*;

public class BucketSort implements Sort{

    @Override
    public void accept(int[] ints) {
        if(ints.length < 2){
            return;
        }

        Map<Integer, int[]> buckets = formBuckets(ints);
        buckets.values().forEach(this);

        int[] sorted = formArray(buckets, ints.length);

        System.arraycopy(sorted, 0, ints, 0, ints.length);
    }

    private int msBits(int[] array, int el, int bucketsCount) {
        long max = Arrays.stream(array).max().getAsInt();
        long min = Arrays.stream(array).min().getAsInt();

        return (int) ((el - min) / ((double) (max - min + 1) / bucketsCount));
    }

    private Map<Integer, int[]> formBuckets(int[] array){
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        int bucketsNumb;

        if(array.length < 4){
            bucketsNumb = 2;
        }else {
            bucketsNumb = (int) Math.sqrt(array.length);
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

    private Map<Integer, int[]> convertToArrBuckets(Map<Integer, List<Integer>> buckets){
        Map<Integer, int[]> converted = new LinkedHashMap<>();

        for(Map.Entry<Integer, List<Integer>> entry : buckets.entrySet()){
            converted.put(entry.getKey(), entry.getValue().stream().mapToInt(a -> a).toArray());
        }

        return converted;
    }

    private int[] formArray(Map<Integer, int[]> buckets, int arrLength) {
        int[] result = new int[arrLength];
        int offset = 0;

        for(int[] bucket : buckets.values()){
            System.arraycopy(bucket, 0, result, offset, bucket.length);
            offset += bucket.length;
        }

        return result;
    }

}