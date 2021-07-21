package category.array;

import java.util.*;

public class MinRectangularArea {


    public static int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        int minArea = Integer.MAX_VALUE;
        //1. group by the x
        //3. sort the y
        HashMap<Integer, List<Integer>> xyMap = getXYMap(points);
        ArrayList<Integer> sortedX = new ArrayList<>(xyMap.keySet());
        //2. sort the x
        Collections.sort(sortedX);
        //4. use y1-y2 pairs to record the nearest y1-y2 -> x
        HashMap<String, Integer> edgesParallelToYAxis = new HashMap<>();

        for (Integer x : sortedX) {
            List<Integer> sortedYValues = xyMap.get(x);
            Collections.sort(sortedYValues);
            for (int i = 1; i < sortedYValues.size(); i++)
                for (int j = 0; j < i; j++) {
                    String twoY = sortedYValues.get(j) + ":" + sortedYValues.get(i);
                    if (edgesParallelToYAxis.containsKey(twoY)) {
                        int currentArea = (x - edgesParallelToYAxis.get(twoY)) * (sortedYValues.get(i) - sortedYValues.get(j));
                        minArea = Math.min(minArea, currentArea);
                    }
                    edgesParallelToYAxis.put(twoY, x);
                }
        }


        return minArea == Integer.MAX_VALUE ? 0 : minArea;

    }

    public static HashMap<Integer, List<Integer>> getXYMap(int[][] points) {
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (res.containsKey(points[i][0])) {
                res.get(points[i][0]).add(points[i][1]);
            } else {
                ArrayList<Integer> yList = new ArrayList<>();
                yList.add(points[i][1]);
                res.put(points[i][0], yList);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{

                {1, 5},
                {5, 1},
                {4, 2},
                {2, 4},
                {2, 2},
                {1, 2},
                {4, 5},
                {2, 5},
                {-1, -2}

        };

        int res = minimumAreaRectangle(points);
        System.out.println(res);

    }
}
