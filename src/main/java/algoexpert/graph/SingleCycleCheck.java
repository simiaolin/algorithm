package algoexpert.graph;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int numOfVisited = 0;
        int currentIndex = 0;
        while (numOfVisited < array.length) {
            if (currentIndex == 0 && numOfVisited > 0) {  //not the first time visiting first element but there are elements unvisited.
                return false;
            }
            numOfVisited++;
            currentIndex = getNextIndex_Op(currentIndex, array[currentIndex], array.length);
        }
        return currentIndex == 0;                   //make sure that has jumped out of the loop
     }

    public static int getNextIndex_Op(int currentIndex, int move, int size) {   //很好的解决循环中index下标问题
        int mod = (currentIndex + move) % size;
        return (mod >= 0) ? mod : mod + size;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, -1};
        System.out.println(hasSingleCycle(arr));
        System.out.println(-8 % 6);
        System.out.println(8 % 6);
    }

    //deprecated
    public static int getNextIndex(int currentIndex, int move, int size) {
        int res;
        if (move >= 0) {
            res =  (currentIndex + move) % size;
        } else {
            res =  (currentIndex + move < 0) ? size - Math.abs(currentIndex+move) % size : (currentIndex+move) % size;
            if (res == size) {
                res = 0;
            }
        }
        return res;
    }

    //deprecated
    public static boolean hasSingleCycleOld(int[] array) {
        // Write your code here.
        boolean[] hasVisited = new boolean[array.length];
        int visitCnt = 0;
        int curIndex= 0;
        while (visitCnt < array.length) {
            if (hasVisited[curIndex]) {
                return false;
            }
            hasVisited[curIndex] = true;
            curIndex = getNextIndex_Op(curIndex, array[curIndex], array.length);
            visitCnt++;
        }
        if (curIndex == 0) {

            return true;
        } else {
            return false;
        }
    }

}
