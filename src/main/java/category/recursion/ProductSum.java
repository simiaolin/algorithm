package category.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        // Write your code here.

        return productSum(array, 1);
    }
    public static int productSum(List<Object> array, int depth) {
        // Write your code here.
        int res = 0;
        for (Object o : array) {
            if (o instanceof Integer) {
                res += (Integer)o;
            } else {
                res += (depth + 1) * productSum((List<Object>)o, depth + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        //[5, 2, [7, -1], 3, [6, [-13, 8], 4]]
        List<Object> arr = Arrays.asList(-13, 8);
        List<Object> arr2 = Arrays.asList(6, arr, 4);
        List<Object> arr3 = Arrays.asList(7, -1);
        List<Object> arr4 = Arrays.asList(5, 2, arr3, 3, arr2);
        int res = productSum(arr4);
        System.out.println(res);
    }
}
