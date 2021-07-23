package category.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {
    /**
     * build a balanced tree
     * @param array sorted array
     * @return a relatively balanced tree
     */
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBst(array, 0 , array.size());
    }

    public static BST minHeightBst(List<Integer> array, int start, int end) {
        if (end - start ==  2) {
            return new BST(array.get(start), null, new BST(array.get(end - 1)));
        } else if (end - start == 1) {
         return new BST(array.get(start));
        } else {
            int middleIdx = (start + end) / 2;
            BST left = minHeightBst(array, start, middleIdx);
            BST right = minHeightBst(array, middleIdx + 1, end);
            return new BST(array.get(middleIdx), left, right);
        }
    }
    public static void main(String[] args) {
        int[] sorted = new int[]{1, 2, 5, 7, 10, 13, 14, 15, 22};
        List<Integer> sortedList = new ArrayList<>();
        for (int i : sorted) {
            sortedList.add(i);
        }
        BST tree = minHeightBst(sortedList);
        System.out.println(tree);
    }
}
