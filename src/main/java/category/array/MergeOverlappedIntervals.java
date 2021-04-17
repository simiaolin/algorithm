package category.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappedIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        int[][] sortedIntervals = intervals.clone();
        //change on the content would not have an effect on the old matrix.
        //change on the object would have an effect too
        //but new an object on the matrix would not have an effect.
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0])); // 如果是array,用Collections.sort

        List<int[]> res = new ArrayList<>();

        int[] currentInterval = sortedIntervals[0];
        for (int[] nextInterval : sortedIntervals) {
            if (nextInterval[0] > currentInterval[1]) {
                res.add(new int[] {currentInterval[0], currentInterval[1]});           //int[] 是以一个reference，要非常注意。
                currentInterval[0] = nextInterval[0];
                currentInterval[1] = nextInterval[1];
            } else {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }
        }
        res.add(currentInterval);
        return res.toArray(new int[res.size()][]);   //no need to define the second size
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
               {1, 2},
   {3, 5},
   {4, 7},
   {6, 8},
   {9, 10}
        };

        int[][] realIntervals = mergeOverlappingIntervals(intervals);
        for (int[] interval : realIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
