package category.searching;

//边界值， 寻找最能概括的
//往往也是对称的
public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int left = 0;
        int right = array.length - 1;
        return shiftedBinarySearch(array, left, right, target);
    }

    public static int shiftedBinarySearch(int[] array, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return mid;
        } else {
            if (mid == left) {  //only two left.
                return target == array[right] ? right : -1;
            } else {
                if (array[left] < array[mid])   {  //左半边是单调的
                    if (target >= array[left] && target <= array[mid]) {
                        return shiftedBinarySearch(array, left, mid, target);
                    } else {
                        return shiftedBinarySearch(array, mid, right, target);
                    }
                } else {       //右半边是单调的
                    if (target >= array[mid] && target <= array[right]) {
                        return shiftedBinarySearch(array, mid, right, target);
                    } else {
                        return shiftedBinarySearch(array, left, mid, target);
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target =33;
        System.out.println(shiftedBinarySearch(arr, target));
    }
}
