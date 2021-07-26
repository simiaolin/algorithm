package category.sort;

import category.Utils;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[j]) {
                    Utils.swap(array, i, j);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] in = new int[]{8, 5, 2, 9, 5, 6, 3};
        bubbleSort(in);
        Utils.printArray(in);
    }
}
