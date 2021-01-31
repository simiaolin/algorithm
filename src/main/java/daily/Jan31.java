package daily;

public class Jan31 {

    //permutation problem
    public void nextPermutation(int[] nums) {
        int l = nums.length - 1;
        //从后往前找递增
        while (l - 1 >= 0 &&
        nums[l - 1] >= nums[l]) {
            l--;
        }
        if (l - 1 >= 0 ) {
            //当整个数不是最大可能值时
            //从后往前找第一个比需要修改的数大的数
            for (int idx = nums.length - 1; idx >= l; idx--) {
                if (nums[l-1] < nums[idx]) {
                    swap(nums, l-1, idx);
                    break;
                }
            }
        }

        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }

    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        Jan31 j31 = new Jan31();
        j31.printResultOfExample(new int[]{ 1,3,2});

    }

    public void printResultOfExample(int[] nums) {
        Jan31 j31 = new Jan31();
        j31.nextPermutation(nums);
        for (int num : nums) {
            System.out.print( " "+ num);
        }

    }
}
