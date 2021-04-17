package category.array;

public class LongestPeak {
   //不要想太多，把问题简单化
    public static int longestPeak(int[] array) {
        int longestPeak = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPeak(i, array)) {
                int currentPeak = getPeakLenght(i, array);
                if (currentPeak > longestPeak) {
                    longestPeak = getPeakLenght(i, array);
                }
            }
        }
        return longestPeak;
    }

    public static boolean isPeak(int index, int[] array) {
        if (index - 1 >= 0 && index + 1 < array.length && array[index - 1] < array[index] && array[index + 1] < array[index]) {
            return true;
        } else {
            return false;
        }
    }

    public static int getPeakLenght(int index, int[] array) {
        int left = index - 1;
        while (left - 1 >= 0 && array[left - 1] < array[left]) {
            left--;
        }
        int right = index + 1;
        while (right + 1 < array.length && array[right] > array[right + 1]) {
            right++;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(arr));
    }

}
