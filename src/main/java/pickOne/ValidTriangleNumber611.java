package pickOne;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidTriangleNumber611 {
    //把三个loop 变成两个loop
    //把逐渐+1 改成一次加一个范围的数
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int C = 2; C < nums.length; C++) {
            int l = 0;
            int r = C - 1;
            while(r > l) {
                if (nums[l] + nums[r] > nums[C]) {
                    //右边固定， 左右有r-l个选择
                     res += r - l;
                     r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
    public int triangleNumberOld(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int z = j+1; z < nums.length; z++) {
                    if (nums[z] >= nums[i] + nums[j]) {
                        break;
                    } else {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ValidTriangleNumber611 v = new ValidTriangleNumber611();
      int[] nums = new int[]{2,2,3,4};
      int res = v.triangleNumber(nums);
        System.out.println(res);
    }
}
