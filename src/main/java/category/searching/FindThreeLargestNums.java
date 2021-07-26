package category.searching;

import java.util.PriorityQueue;

public class FindThreeLargestNums {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        PriorityQueue<Integer> p = new PriorityQueue<>(3);
        for (int i = 0; i < 3; i++) {
            p.offer(array[i]);
        }

        for (int i = 4; i < array.length; i++) {
            if (array[i] > p.peek()) {
                p.poll();
                p.offer(array[i]);
            }
        }

        int[] res = new int[3];
        for (int i = 0 ; i < 3; i++) {
            res[i] = p.poll();
        }

        if (res[1] > res[2]) {
            int t = res[1];
            res[1] = res[2];
            res[2] = t;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7};
        int[] res = findThreeLargestNumbers(in);
        for (int n : res) {
            System.out.println(n);
        }
        System.out.println(res);
    }
}
