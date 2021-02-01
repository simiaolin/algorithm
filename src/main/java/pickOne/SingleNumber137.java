package pickOne;

public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        int s = 0;
        for (int i =0; i < 32; i++) {
            for (int num : nums) {
                s += (num >> i) & 1;
            }
            res += (s % 3) << i;
            s = 0;
        }
        return res;
    }
    public static void main(String[] args) {
        SingleNumber137 s  = new SingleNumber137();
        int[] nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(s.singleNumber(nums));
    }
}
