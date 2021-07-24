package category.tree;

import java.util.Arrays;
import java.util.List;

//trick: use index instead of the whole array
public class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return sameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int idx1, int idx2, int min, int max) {
        //if there is no more element, both two arrays should not have element.
        if (idx1 == -1 || idx2 == -1) {
            if (idx1 == -1 && idx2 == -1) {
                return true;
            } else {
                return false;
            }
        }

        //assure the first one is equal
        if (arrayOne.get(idx1) != arrayTwo.get(idx2)) {
            return false;
        }

        int num = arrayOne.get(idx1);
        int right1 = findFirstIdx(arrayOne, idx1, num, max);
        int left1 = findFirstIdx(arrayOne, idx1, min, num);

        int right2 = findFirstIdx(arrayTwo, idx2, num, max);
        int left2 = findFirstIdx(arrayTwo, idx2, min, num);

        boolean isSameLeft = sameBsts(arrayOne, arrayTwo, left1, left2, min, num);
        boolean isSameRight = sameBsts(arrayOne, arrayTwo, right1, right2, num, max);
        return isSameLeft && isSameRight;

    }

    public static int findFirstIdx(List<Integer> array, int idx, int min, int max) {
        for (int i = idx + 1; i < array.size(); i++) {
            if (array.get(i) >= min && array.get(i) < max) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> one = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
        List<Integer> two = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
        boolean res = sameBsts(one, two);
        System.out.println(res);
    }
}
