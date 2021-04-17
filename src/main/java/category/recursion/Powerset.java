package category.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        if (array.size() == 0) {             //注意边界条件
            return Arrays.asList(new ArrayList<>());
        } else {
            return powerset(array, array.size() - 1);
        }

    }

    public static List<List<Integer>> powerset(List<Integer> array, int lastIndx) {
        if (lastIndx == 0) {
            List<Integer> l = Arrays.asList(array.get(0));
            List<Integer> empty = Arrays.asList();
            return Arrays.asList(l, empty);
        } else {
            List<List<Integer>> formerPowersets = powerset(array, lastIndx - 1);
            List<List<Integer>> newlyAddedPowersets = new ArrayList<>();
            for (List<Integer> formerPowerset : formerPowersets) {
                List<Integer> newAddedPowerset = new ArrayList<>();
                newAddedPowerset.add(array.get(lastIndx));
                newAddedPowerset.addAll(formerPowerset);
                newlyAddedPowersets.add(newAddedPowerset);
            }
            newlyAddedPowersets.addAll(formerPowersets);
            return newlyAddedPowersets;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3);       //create a fixed size array list
        List<List<Integer>> res = powerset(arr);
        for (List<Integer> set : res) {
            for (Integer n : set) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
