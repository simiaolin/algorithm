package algoexpert;

public class MaxSubsetNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        int max = 0;
        if (array.length > 0) {
            if (array.length == 1) {
                return array[0];
            } else if (array.length == 2) {
                return Math.max(array[0], array[1]);
            } else {
                array[2] += array[0];
                max = Math.max(array[2], array[1]);
                for (int i = 3; i < array.length; i++) {
                    array[i] += Math.max(array[i-2], array[i-3]);
                    max = Math.max(max, array[i]);
                }
            }
        }
        return max;

    }
}
