package category.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zigzag {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        int height = array.size();
        if (height == 0) {
            return res;
        } else {
            int width = array.get(0).size();
            if (width == 0) {
                return res;
            } else {
                boolean isUp = false;    //first one could be seen as the result of going down, as next step is going up.
                int i = 0;
                int j = 0;
                while (!beyondBorder(i, j, height, width)) {
                    res.add(array.get(i).get(j));
                    if (isUp) {
                        if (isEndOfUp(i, j, height, width)) {   //check special case of going up
                            if (hasTouchRightEdge(i, j, height, width)) {
                                i++;
                            } else {
                                j++;
                            }
                            isUp = false;
                        } else {
                            i--;
                            j++;
                        }
                    } else {
                        if (isEndOfDown(i, j, height, width)) {
                            if (hasTouchBottomEdge(i, j, height, width)) {
                                j++;
                            } else {
                                i++;
                            }
                            isUp = true;
                        } else {
                            i++;
                            j--;
                        }
                    }

                }
                return res;
            }
        }
    }

    public static boolean beyondBorder(int i, int j, int height, int width) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return true;
        }
        return false;
    }

    public static boolean isEndOfUp(int i, int j, int height, int width) {
        if (i == 0 || j == width - 1) {
            return true;
        }
        return false;
    }

    public static boolean isEndOfDown(int i, int j, int height, int width) {
        if (i == height - 1 || j == 0) {
            return true;
        }
        return false;
    }

    public static boolean hasTouchRightEdge(int i, int j, int height, int width) {
        return j == width - 1;
    }

    public static boolean hasTouchBottomEdge(int i, int j, int height, int width) {
        return i == height - 1;
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 3, 4, 10));
        list.add(Arrays.asList(2, 5, 9, 11));
        list.add(Arrays.asList(6, 8, 12, 15));
//        list.add(Arrays.asList(7, 13, 14, 16));
        List<Integer> res = zigzagTraverse(list);
        System.out.println(res);
    }

}