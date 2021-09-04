package category.binarysearchtree;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int indexOfSubsequence = 0;
        for (int i = 0; i < array.size(); i++) {
            if (indexOfSubsequence == sequence.size()) {
                return true;
            }
            if (array.get(i) == sequence.get(indexOfSubsequence)) {
                indexOfSubsequence++;
            }
        }
        return indexOfSubsequence == sequence.size()? true : false;

    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer>  sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}
