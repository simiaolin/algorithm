package algoexpert.array;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int[] smallestPair = new int[2];
        int currentSmallestDifference = Integer.MAX_VALUE;
        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            if (arrayOne[indexOne] == arrayTwo[indexTwo]) {
                return new int[] {arrayOne[indexOne], arrayTwo[indexTwo]};
            }
            if (Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]) < currentSmallestDifference) {
                smallestPair[0] = arrayOne[indexOne];
                smallestPair[1] = arrayTwo[indexTwo];
                currentSmallestDifference = Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]);    //最重要的 一定要更新最小距离
            }
            if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
                indexOne++;
            } else {
                indexTwo++;
            }
        }
        return smallestPair;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {-1, 5, 10, 20, 3};
        int[] arr2 = new int[] {21, 134, 135, 15, 17};
        for (int i : smallestDifference(arr1, arr2)) {
            System.out.println(i);
        }
    }
}
