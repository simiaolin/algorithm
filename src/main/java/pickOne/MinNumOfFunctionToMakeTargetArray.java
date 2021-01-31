package pickOne;

public class MinNumOfFunctionToMakeTargetArray {
    public int minOperations(int[] nums) {
        int addOneCount = 0;
        int multiplyByTwoCount = 0;
        for (int num : nums) {
            //尤其注意对0的处理
            if (num == 0 ) {
                addOneCount--;
            }
            int left = num;
            int currentMultiplyByTwoCount = 0;
            while (left > 1) {
                if (!isOdd(left)) {
                    addOneCount += 1;
                }
                left = left >> 1;
                currentMultiplyByTwoCount++;
            }

            multiplyByTwoCount = Math.max(multiplyByTwoCount, currentMultiplyByTwoCount);

        }
        return addOneCount + multiplyByTwoCount + nums.length;
    }
    public int minOperationsOld(int[] nums) {
        int addOneCount = 0;
        int multiplyByTwoCount = 0;
        for (int num : nums) {
            String bString = Integer.toBinaryString(num);
            multiplyByTwoCount = Math.max(multiplyByTwoCount, bString.length() - 1);
            for (Byte i : bString.getBytes()) {
                // 判断i是否为1
                if (i == 49) {
                    addOneCount++;
                }
            }
            //误打误撞让 num=0的情况也过了测试
            addOneCount--;
        }
        return addOneCount + multiplyByTwoCount + nums.length;
    }

    public boolean isOdd(int i) {
        if ((i & 1) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        MinNumOfFunctionToMakeTargetArray m = new MinNumOfFunctionToMakeTargetArray();
        System.out.println(m.minOperationsOld(nums));


    }
}
