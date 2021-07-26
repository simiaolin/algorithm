package category.greedy;

import java.util.Arrays;

public class MinWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int res = 0;
        for (int i = 0 ; i < queries.length - 1; i++) {
            res += queries[i] * (queries.length - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] qs = new int[]{3, 2, 1, 2, 6};
        System.out.println(new MinWaitingTime().minimumWaitingTime(qs));
    }
}
