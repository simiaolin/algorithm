package category.dynamic_programming;

public class MinJumps {
    // spend more time on complete the requirement instead of improving,
    // if improving is not that easy.
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        if (array.length  == 1){
            return 0;
        }
        int res = 0;
        int leftStep = array[0];
        int maxReach = array[0];
        for (int i = 1; i < array.length; i++) {
            maxReach = Math.max(maxReach, array[i] + i);

            leftStep--;
            if (leftStep == 0 || i == array.length - 1) {
                leftStep = maxReach - i;
                res++;
            }
        }

        return res;


    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        int[] arr = new int[]{3, 4};
        int res = minNumberOfJumps(arr);
        System.out.println(res);
    }
}
