package algoexpert.searching;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int width = matrix[0].length;
        int height = matrix.length;
        int[] currentIdx = new int[] {0, width - 1};
        while (matrix[currentIdx[0]][currentIdx[1]] != target) {
            if (matrix[currentIdx[0]][currentIdx[1]] > target) {   //to left
                if (currentIdx[1] - 1 >= 0) {
                    currentIdx[1]--;
                } else {
                    return new int[]{-1, -1};
                }
            } else {                  // to down
                if (currentIdx[0] + 1 < height) {
                    currentIdx[0]++;
                } else {
                    return new int[]{-1, -1};
                }
            }
        }
        return currentIdx;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };
        int[] res = searchInSortedMatrix(matrix, 44);
        System.out.println(res[0] + " " + res[1]);
    }
}
