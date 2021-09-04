package category;

import java.util.ArrayList;

public class Utils {
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i + " ");
        }
    }

    public static void printArray(ArrayList<String> array) {
        for (String i : array) {
            System.out.println(i);
        }
    }


    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
