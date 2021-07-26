package category.searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else {
                if (array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return array[start] == target ? start : -1;

    }


    public static void main(String[] args) {
        int[] in = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int res = binarySearch(in, 33);
        System.out.println(res);
    }
}
