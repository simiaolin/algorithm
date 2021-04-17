package codejam.women2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ASolution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // get total number
        int T = in.nextInt();
        // handle each task
        for(int i=0; i<T; i++){
            // get number of ingredients
            int K = in.nextInt();
            // store each optimal distance
            int[] D = new int[K];
            for(int j=0; j<K; j++){
                D[j] = in.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + getMinSum(D));
        }
        in.close();
    }

    public static int getMinSum(int[] arr) {

        Arrays.sort(arr);
        int sum = 1;
        int formerIndx = 0;
        int index = 1;
        int currentFood = 1;
        while(index < arr.length) {
            if (arr[index] != arr[index - 1]) {
                currentFood++;
            }
            sum += currentFood;
            formerIndx++;
            index++;
        }
        return sum;
    }
}
