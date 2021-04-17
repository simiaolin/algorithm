package category.graph;

import java.util.ArrayList;
import java.util.List;


//time : o(mn) space: o(1)
//no need to store a  so called visited matrix
public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {    //虽然挨个遍历了，但每个节点最多被邻居访问一次，也就是最多4次
                if (matrix[i][j] == 1) {
                    sizes.add(getCurrentRiverCnt(i, j, matrix));
                }
            }
        }
        return sizes;
    }

    public static int getCurrentRiverCnt(int i, int j, int[][] matrix) {
        int riverSize = 1;
        //
        matrix[i][j] = 0;      //sign of visited, not much different from an island
//        int[] unvisitedRiverNeighbour = getunvisitedRiverNeighbour(i, j, matrix);       //不能提前获取未被遍历的河流，因为其可能被前面的河流遍历的时候覆盖了。
        for (int[] riverNeighbour : getRiverNeighbours(i, j, matrix)) {
            if (matrix[riverNeighbour[0]][riverNeighbour[1]] == 1) {                //需要在里层判断
                riverSize += getCurrentRiverCnt(riverNeighbour[0], riverNeighbour[1], matrix);
            }
        }
        return riverSize;
    }


    public static List<int[]> getRiverNeighbours(int i, int j, int[][] matrix) {
        int[] neighbourIs = new int[]{i - 1, i + 1};
        int[] neighbourJs = new int[]{j - 1, j + 1};
        List<int[]> res = new ArrayList<>();

        for (int neighbourI : neighbourIs) {
            if (isInsideMatrix(neighbourI, j, matrix) ) {
                res.add(new int[]{neighbourI, j});
            }
        }
        for (int neighbourJ : neighbourJs) {
            if (isInsideMatrix(i, neighbourJ, matrix) ) {
                res.add(new int[]{i, neighbourJ});
            }
        }
        return res;
    }

    public static boolean isInsideMatrix(int i, int j, int[][] matrix) {
        if (0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] matrix2 = new int[][]{
                {1, 1},
                {1,  1}


        };

        System.out.println(riverSizes(matrix));
    }
}
