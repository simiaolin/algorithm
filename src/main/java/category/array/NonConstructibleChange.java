package category.array;

import java.util.ArrayList;
import java.util.Arrays;

//排序
//记录当前最大和
public class NonConstructibleChange {
    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        int currentMax = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > currentMax + 1) {
                return currentMax+1;
            } else {
                currentMax+= coins[i];
            }
        }

        return currentMax + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        System.out.println(nonConstructibleChange(input));
    }
}
