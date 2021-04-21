package codejam.april;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    static String readpath = "./ins/small-practice.in";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader(readpath));

        // get total number
        int T = in.nextInt();
        // handle each task
        for (int i = 0; i < T; i++) {
            // get number of ingredients
            int K = in.nextInt();
            int b = in.nextInt();
            // store each optimal distance
            int[] D = new int[K];
            for (int j = 0; j < K; j++) {
                D[j] = in.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + getMaxRooms(D, b));
        }
        in.close();
    }

    public static int getMaxRooms(int[] cost, int budget) {
        Arrays.sort(cost);
        int cnt = 0;
        for (int i = 0; i< cost.length; i++) {
            if (budget >= cost[i]) {
                cnt++;
                budget -= cost[i];
            }
        }
        return cnt;
    }

}
