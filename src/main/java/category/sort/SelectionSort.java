package category.sort;

import category.Utils;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(array, i, minIndex);
            }
        }
        return array;

    }


    public static void main(String[] args) {
        int[] in = new int[]{8, 5, 2, 9, 5, 6, 3};
        selectionSort(in);
        Utils.printArray(in);
    }
}
