package category.array;

public class FirstDuplicateValue {

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i+1) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 1, 5, 2, 3, 3, 4};
        int res  = firstDuplicateValue(input);
        System.out.println(res);
    }
}
