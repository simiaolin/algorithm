package category.graph;

import java.util.Arrays;

public class CycleInGraph {
    public int WHITE = 0;
    public int GREY = 1;
    public int BLACK = 2;

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        int[] colors = new int[edges.length];
        Arrays.fill(colors, WHITE);
        for (int i = 0; i < edges.length; i++) {
            if (colors[i] != WHITE) continue;  // only visit unvisited ones.
            boolean isCycle = dfs(i, edges, colors);
            if (isCycle) return true;
        }
        return false;
    }

    public boolean dfs (int vertex, int[][] edges, int[] colors) {
        colors[vertex] = GREY;
        for (int neighbour : edges[vertex]) {
            if (colors[neighbour] == GREY) {
                return true;
            }

            if (colors[neighbour] == BLACK) {
                continue;
            }

            boolean isNeighbourCycle = dfs(neighbour, edges, colors);
            if (isNeighbourCycle) {
                return true;
            }

        }

        colors[vertex] = BLACK;   //all its neighbour is black;
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };
        boolean res = new CycleInGraph().cycleInGraph(input);
        System.out.println(res);
    }
}
