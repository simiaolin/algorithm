package codejam.april;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Training {
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
            System.out.println("Case #" + (i + 1) + ": " + getLeaseTraining(D, b));
        }
        in.close();
    }

    public static int getLeaseTraining(int[] skills, int p) {
        Arrays.sort(skills);
        int sizeOfAllPlayers = skills.length;
        int currentTrain = 0;

        for (int i = 0; i < p-1; i++) {
            currentTrain += skills[p-1] - skills[i];
        }
        int minTrain = currentTrain;

        for (int currentMaxPlayerIdx = p; currentMaxPlayerIdx < sizeOfAllPlayers; currentMaxPlayerIdx++) {
            currentTrain -= skills[currentMaxPlayerIdx - 1] - skills[currentMaxPlayerIdx - p];
            currentTrain += (p -1)* (skills[currentMaxPlayerIdx] - skills[currentMaxPlayerIdx - 1]);
            if (currentTrain < minTrain) {
                minTrain = currentTrain;
            }
        }
        return minTrain;
    }

}
