package codejam.women2021;

import java.io.*;
import java.util.Scanner;

public class BSolution {

    static String readpath = "./ins/small-practice.in";
    static String outpath = "./outs/small-practice.txt";

    public static void main(String[] args) throws IOException {

        // read file
        Scanner in = new Scanner(new FileReader(readpath));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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

            System.out.println("Case #" + (i + 1) + ": " + getFinalString(D));
//            out.append("Case #" + (i + 1) + ": " + getFinalString(D) + '\n');

        }

        in.close();
//        out.close();


    }

    public static String getFinalString(int[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("A");
        int length = arr.length;
        int odd_even_couple_index_max = length / 2;
        for (int i = 0 ; i < odd_even_couple_index_max; i++) {
            int odd_size = arr[i*2];
            int even_size = arr[i * 2  + 1];
            for (int k = 0; k < odd_size - 1;k++) {
                sb.append((char)(66+k));
            }
            if (even_size > odd_size) {
                sb.append((char) (65 + even_size));
            } else {
                sb.append((char)(66+odd_size-1));
            }
            for (int k = even_size - 1; k >=0; k--) {
                sb.append((char) (65+k));
            }
        }
        if (length % 2 != 0) {
            int final_odd_size = arr[length - 1];
            for (int k = 0; k < final_odd_size; k++) {
                sb.append((char)(66 + k));
            }
        }
        return sb.toString();
    }

}
