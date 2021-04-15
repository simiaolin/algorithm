package algoexpert.dynamic_programming;

import java.util.LinkedList;
import java.util.Queue;

//time complexity o(m  * n)  where m is the height, n is the width
//space complexity o(size * n)

//the sum of the right corner. time : o(m * n) space :o (m*n)
//easy to understand
// 此题目对边界的思考也值得借鉴
public class MaximunSumMatrix {

    public int maximumSumSubmatrix(int[][] matrix, int size) {
        // Write your code here.
        int height = matrix.length;
        int width = matrix[0].length;
        Sum[] blockSum = new Sum[width - size + 1];
        for (int i = 0; i < blockSum.length; i++) {
            blockSum[i] = new Sum();
        }
        int max = Integer.MIN_VALUE;

        //init first <size> rows
        for (int i = 0; i < size; i++) {
            int[] sumOfCurrentRow = getSumOfEachRow(matrix, i, size);
            for (int k = 0; k < width - size + 1; k++) {
                blockSum[k].sumPerRow.add(sumOfCurrentRow[k]);
                blockSum[k].oversum += sumOfCurrentRow[k];
                if (i == size - 1 && blockSum[k].oversum > max) {
                    max = blockSum[k].oversum;
                }
            }
        }

        //iterate other rows
        for (int i = size; i < height; i++) {
            int[] sumOfCurrentRow = getSumOfEachRow(matrix, i, size);
            for (int k = 0; k < width - size + 1; k++) {
                blockSum[k].oversum -= blockSum[k].sumPerRow.poll();
                blockSum[k].sumPerRow.add(sumOfCurrentRow[k]);
                blockSum[k].oversum += sumOfCurrentRow[k];
                if (blockSum[k].oversum > max) {
                    max = blockSum[k].oversum;
                }
            }
        }

        return max;
    }

    class Sum {
        Queue<Integer> sumPerRow;
        int oversum;

        public  Sum(){
            sumPerRow = new LinkedList<>();
            oversum = 0;
        }
    }

    public int[] getSumOfEachRow(int[][] matrix, int rowIdx, int size) {
        int width = matrix[0].length;
        int[] sumOfCurerntRow = new int[width - size + 1];
        for (int i = 0; i < size; i++) {
            sumOfCurerntRow[0] += matrix[rowIdx][i];
        }
        for (int i = 1; i < sumOfCurerntRow.length; i++) {
            sumOfCurerntRow[i] = sumOfCurerntRow[i - 1];
            sumOfCurerntRow[i] -= matrix[rowIdx][i - 1];
            sumOfCurerntRow[i] += matrix[rowIdx][i+size-1];
        }
        return sumOfCurerntRow;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 3, -1, 5},
                {-7, 3, 7, 4},
                {12, 8, 0, 0},
                {1, -8, -8, 2}
        };
        System.out.println(new MaximunSumMatrix().maximumSumSubmatrix(matrix, 2));
    }
}
