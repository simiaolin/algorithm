package category.sort;

import category.Utils;

//like playing with the cards.
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 1; i < array.length; i++) {
            while (i > 0 && array[i-1] > array[i]) {
                Utils.swap(array, i, i-1);
                i--;
            }
        }
        return  array;
    }

    public static void main(String[] args) {
        int[] in = new int[]{8, 5, 2, 9, 5, 6, 3};
        insertionSort(in);
        Utils.printArray(in);
    }
}
