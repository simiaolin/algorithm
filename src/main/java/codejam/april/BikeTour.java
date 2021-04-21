package codejam.april;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BikeTour {
    static String readpath = "./ins/small-practice.in";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader(readpath));

        // get total number
        int T = in.nextInt();
        // handle each task
        for (int i = 0; i < T; i++) {
            // get number of ingredients
            int K = in.nextInt();
            // store each optimal distance
            int[] D = new int[K];
            for (int j = 0; j < K; j++) {
                D[j] = in.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + getPeakCnt(D));
        }
        in.close();
    }

    public static int getPeakCnt(int[] heights) {
        int cnt = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
                cnt++;
            }
        }
        return cnt;
    }

}
