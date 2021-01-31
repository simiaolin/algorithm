package daily;

import java.util.PriorityQueue;

public class Jan30 {
    public int minimumDeviation(int[] nums) {
        //大的在前面
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a, b) -> b-a);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 != 0) {
                num = num * 2;
            }
            //加入num
            pq.offer(num);
            min = Math.min(min, num);
            max= Math.max(max, num);
        }
        res = max - min;

        while (pq.size() > 0) {
            //弹出最大
            int currentTop =  pq.poll();
            if (currentTop % 2 != 0) break;

//            int beforeDistance = max - min;
            //最好的结果是全局的， 而不是当前的，也就是说，有可能是很久以前的。
            min = Math.min(min, currentTop / 2);
            pq.offer(currentTop / 2);
            //获取最大并不取出
            max = pq.peek();
            int afterDistance = max - min;
            res = Math.min(res, afterDistance);
        }
        return res;
    }

    public static void main(String[] args) {
        Jan30 jan30 = new Jan30();
        int[] nums = new int[]{399,908,648,357,693,502,331,649,596,698};
        int res1 = jan30.minimumDeviation(nums);
        System.out.println(res1);
    }
}
