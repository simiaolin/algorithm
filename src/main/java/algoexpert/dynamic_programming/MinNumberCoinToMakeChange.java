package algoexpert.dynamic_programming;

import java.util.Arrays;

public class MinNumberCoinToMakeChange {

    //time complexity O(N*D)
    //space complexity O(N)
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
    int[] minNumberOfCoinsArray = new int[n+1];
    Arrays.fill(minNumberOfCoinsArray, Integer.MAX_VALUE);
    minNumberOfCoinsArray[0] = 0;
    for (int denom : denoms) {
        for (int amount = denom; amount < n + 1; amount++) {
                int toCompare = (minNumberOfCoinsArray[amount - denom] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minNumberOfCoinsArray[amount - denom] + 1;
                minNumberOfCoinsArray[amount] = Math.min(minNumberOfCoinsArray[amount], toCompare);
        }
    }

    return (minNumberOfCoinsArray[n] == Integer.MAX_VALUE) ? -1 : minNumberOfCoinsArray[n];

}

    public static void main(String[] args) {
        int sum = 7;
        int[] denoms = new int[]{1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(sum, denoms));
    }
}
