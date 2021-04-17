package category.array;

import java.util.ArrayList;
import java.util.List;

//非常好的测试边界的题目
public class SpiralTranverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        int startR = 0;
        int startC = 0;
        int endR = array.length - 1;
        int endC = array[0].length - 1;

        while (startR <= endR && startC <= endC) {
            //to right
            for (int col = startC; col <= endC; col++) {
                res.add(array[startR][col]);
            }

            //to down
            for (int row = startR + 1; row <= endR; row++) {
                res.add(array[row][endC]);
            }

            // in case there is a single row
            for (int col = endC - 1; col >= startC; col--) {
                if (startR == endR) {
                    break;
                }
                res.add(array[endR][col]);
            }

            // in case there is single column
            for (int row = endR - 1; row > startR; row--){
                if (startC == endC) {
                    break;
                }
                res.add(array[row][startC]);
            }
            startC++;
            startR++;
            endC--;
            endR--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,2,3},{
                    4,5,6
        },{7,8,9}
        };
        List<Integer> res = SpiralTranverse.spiralTraverse(arr);
        for (Integer r : res) {
            System.out.println(r);
        }
    }
}
