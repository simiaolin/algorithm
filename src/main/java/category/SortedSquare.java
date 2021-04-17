package category;

public class SortedSquare {
    public static  int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] res = new int[array.length];
        int curPosIndex= -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                curPosIndex = i;
                break;
            }
        }
        int curNegIndex;
        if (curPosIndex > -1) {
            curNegIndex  = curPosIndex - 1;
        } else {
            curNegIndex = array.length - 1;
        }
        int newIndex = 0;
        while (curNegIndex > -1 && curPosIndex > -1 && curPosIndex < array.length ) {
            int curNeg = array[curNegIndex];
            int curPos = array[curPosIndex];
            if (Math.abs(curNeg) > curPos) {
                //负数平方大
                res[newIndex++] = curPos * curPos;
                curPosIndex++;
            } else if (Math.abs(curNeg) == curPos) {
                //负数正数平方一样大
                res[newIndex++] = curPos * curPos;
                res[newIndex++] = curPos * curPos;
                curNegIndex--;
                curPosIndex++;
            } else {
                res[newIndex++] = curNeg * curNeg;
                curNegIndex--;
            }
        }

        while (curPosIndex > -1 && curPosIndex < array.length) {
            res[newIndex++] = array[curPosIndex]  * array[curPosIndex];
            curPosIndex++;
        }
        while (curNegIndex > -1) {
            res[newIndex++] = array[curNegIndex]  *  array[curNegIndex];
            curNegIndex--;
        }

        return res;


    }

    public static void main(String[] args) {
        int[] a =new int[] {-1};
        int[] res = sortedSquaredArray(a);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    
}
