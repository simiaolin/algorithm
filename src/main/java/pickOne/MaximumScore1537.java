package pickOne;

import utils.ReadBigArrayFromFile;

import java.io.IOException;

public class MaximumScore1537 {
    //1. 可以用long来存
    //2. 计算单段value的时候是不能用mod的， 会导致结果出错！
    //3. int的最大值大概是20亿， 就是2 * 1e9

    public int maxSum(int[] nums1, int[] nums2) {
        int MOD_VALUE = (int) (1e9 + 7);

        long res = 0;
        if (nums1[nums1.length - 1] < nums2[0]) {
            res =  sum(nums2);
        } else if (nums1[0] > nums2[nums2.length - 1]) {
            res =  sum(nums1);
        } else {
            int fl = 0;
            int sl = 0;
            int fr = 0;
            int sr = 0;
            while (fr < nums1.length && sr < nums2.length) {
                if (nums1[fr] == nums2[sr]) {
                    res = (res + Math.max(sum(nums1, fl, fr), sum(nums2, sl, sr)))  ;
                    fl = fr;
                    sl = sr;
                    sr++;
                    fr++;
                } else if (nums1[fr] > nums2[sr]) {
                    sr++;
                } else {
                    fr++;
                }
            }
            res = (res + Math.max(sum(nums1, fl, nums1.length), sum(nums2, sl, nums2.length))) ;
        }
        return (int) (res % MOD_VALUE);
    }


    public long sum(int[] nums) {
       return sum(nums, 0, nums.length);
    }

    public long sum(int[] nums, int begin, int end) {
        long res = 0;
        for (int i = begin; i < end; i++) {
            res =  (res + nums[i]) ;
        }
        return res;
    }



    public static void main(String[] args) throws IOException {
        MaximumScore1537 m = new MaximumScore1537();
        int[] nums1 = new int[]{1,4,5,8,9,11,19};
        int[] nums2 = new int[]{2,3,4,11,12};
        String f1 = "src/main/resources/arr1";
        String f2 = "src/main/resources/arr2";
        int[] arr1 = ReadBigArrayFromFile.getArrayFromFile(f1);
        int[] arr2 = ReadBigArrayFromFile.getArrayFromFile(f2);
        System.out.println(m.maxSum(arr1, arr2));
        System.out.println(m.maxSum(nums1, nums2));
    }


    public int maxSum2(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9 + 7);
        long dp1 = 0, dp2 = 0;
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    dp1 += nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    dp2 += nums2[j++];
                } else {
                    dp1 = dp2 = Math.max(dp1, dp2) + nums1[i];
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                dp1 += nums1[i++];
            } else {
                dp2 += nums2[j++];
            }
        }

        return (int) (Math.max(dp1, dp2) % MOD);
    }

}
