package category.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//use index instead of copying the entire array
public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array, 0, permutations);
        return permutations;
    }



    public static void getPermutations(List<Integer> array, int i, List<List<Integer>> permutations) {
        // Write your code here.
        if (i == array.size() - 1) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(array, i+1, permutations);
                swap(array, j, i);
            }
        }
    }

    public static void swap (List<Integer> array, int i, int j) {
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }


    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3,2,1);
        List<List<Integer>> res = getPermutations(arr);
        System.out.println("hh");
    }
}
