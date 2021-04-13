package algoexpert.array;

import java.util.*;

//把所有pair找出来 然后排序 再两个index，一个从前，一个从后，计算和是否满足要求
//最大问题是 every number 都有可能在多个pair里面出现 不能保证两个pair的number 是distinct的

//algoexpert的solution
//挨个遍历array，假设当前number一定会被计算，同时记录该index前的pair map， 向后搜索 求出能满足left sum在前面的pair map中的可能，加入结果集合中。
//精髓在于设置了一个bar，就是当前的number， 其前面有两个数，后面一个数。这样子保证了结果集合中所有的可能都是不同的！

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        if (array.length < 4) {
            return new LinkedList<>();
        }
        List<Integer[]> res = new ArrayList<>();

        Map<Integer, List<Integer[]>> previousMap = new HashMap<>();   //sum , possible pairs having a sum of sum
        List<Integer[]> firstPair = new ArrayList<>();
        firstPair.add(new Integer[]{array[0], array[1]});
        previousMap.put(array[0] + array[1], firstPair);
        for (int i = 2; i < array.length - 1; i++) {
            //check for targetSum
            for (int j = i+1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int left = targetSum - currentSum;
                if (previousMap.containsKey(left)) {
                    for (Integer[] validPreviousPair : previousMap.get(left)) {
                        res.add(new Integer[] {array[i], array[j], validPreviousPair[0], validPreviousPair[1]});
                    }
                }
            }

            //add to pairs
            for (int k = 0; k < i; k++) {
                int currentSum = array[k] + array[i];
                if (previousMap.containsKey(currentSum)) {
                    previousMap.get(currentSum).add(new Integer[]{array[k], array[i]});
                } else {
                    List<Integer[]> l = new ArrayList<>();
                    l.add(new Integer[] {array[k], array[i]});
                    previousMap.put(currentSum, l);
                }
            }
        }
        return res;

    }



    public static void main(String[] args) {
        int[] arr  = new int[] {7, 6, 4, -1, 1, 2};
        int target = 16;
        List<Integer[]> res = fourNumberSum(arr, target);
        for (Integer[] p : res) {
            System.out.println(p[0] + " " + p[1] + " " + p[2] + " " + p[3]);
        }
    }
}
