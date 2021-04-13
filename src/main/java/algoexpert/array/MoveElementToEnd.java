package algoexpert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            if (array.get(i) == toMove &&  array.get(j) != toMove) {
                int tmp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, tmp);
            } else {
                if (array.get(i) != toMove) i++;
                if (array.get(j) == toMove) j--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        moveElementToEnd(array, 2);
        for (int i : array) {
            System.out.println(i);
        }

    }
}
