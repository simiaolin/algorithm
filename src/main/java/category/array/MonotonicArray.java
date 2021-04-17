package category.array;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        int flag = 0;      // 1: increase -1: decrease 0:the same
        boolean isMonotonic = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i+1] > array[i]) {
                if (flag >= 0) {
                    flag = 1;
                } else {
                    return false;
                }
            } else if (array[i+1] < array[i]) {
                if (flag <= 0) {
                    flag = -1;
                } else {
                    return false;
                }
            }
        }
        return isMonotonic;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1, -1, -1, -1};
        System.out.println(isMonotonic(arr));
    }
}
