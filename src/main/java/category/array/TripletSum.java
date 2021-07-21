package category.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> res = new ArrayList<>();
        for (int firstIndex = 0 ; firstIndex < array.length - 2; firstIndex++) {
            int firstNum = array[firstIndex];
            int secondIndx = firstIndex + 1;
            int thirdIndx = array.length - 1;
            while (secondIndx < thirdIndx) {
                int sumOfSecondAndThird = array[secondIndx] + array[thirdIndx];
                int leftOverSum = targetSum - firstNum;
                if (sumOfSecondAndThird ==  leftOverSum) {
                    res.add(new Integer[]{firstNum, array[secondIndx], array[thirdIndx]});
                    secondIndx++;
                    thirdIndx--;
                } else if (sumOfSecondAndThird < leftOverSum) {
                    secondIndx++;
                } else {
                    thirdIndx--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int sum = 0;
        List<Integer[]> res = threeNumberSum(t, sum);
        System.out.println(res);
    }
}
