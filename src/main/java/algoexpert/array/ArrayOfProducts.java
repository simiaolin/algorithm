package algoexpert.array;

public class ArrayOfProducts {
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];
        leftProduct[0] = array[0];
        rightProduct[array.length - 1] = array[array.length - 1];
        for (int i = 1 ; i < array.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * array[i];
        }
        for (int j = array.length - 2; j >= 0; j--) {
            rightProduct[j] = rightProduct[j+1] * array[j];
        }
        int[] res = new int[array.length];
        res[0] = rightProduct[1];
        res[array.length - 1] = leftProduct[res.length - 2];
        for (int i =1 ; i < res.length-1; i++) {
            res[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2};
        int[] res = arrayOfProducts(arr);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
