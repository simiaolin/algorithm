package category.array;

import java.util.HashMap;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        // Write your code here.
        HashMap<Integer, Boolean> hasVisited = new HashMap<>();
        for (int num : array) {
            hasVisited.put(num, false);
        }
        int maxRange = 0;
        int[] res = new int[2];
        for (int num :  array) {
            if (!hasVisited.get(num)) {    //have not been visited
                int left = num;
                int right = num;
                while (hasVisited.containsKey(left - 1) && !hasVisited.get(left - 1)) {
                    hasVisited.put(left - 1, false);
                    left--;
                }
                while (hasVisited.containsKey(right + 1) && !hasVisited.get(right + 1)) {
                    hasVisited.put(right + 1, false);
                    right++;
                }
                if (right - left + 1 > maxRange) {
                    maxRange = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inp = new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] res = largestRange(inp);
        System.out.println(res);
    }
}
