package codejam.april;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BigButton {
    static String readpath = "./ins/small-practice.in";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader(readpath));

        // get total number
        int T = in.nextInt();
        // handle each task
        for (int i = 0; i < T; i++) {
            // get number of ingredients
            int n = in.nextInt();
            int p = in.nextInt();
            // store each optimal distance
            String[] D = new String[p];
            for (int j = 0; j < p; j++) {
                D[j] = in.next();
            }
            System.out.println("Case #" + (i + 1) + ": " + getButtonPossibilities(D, n));
        }
        in.close();
    }


    public static long getButtonPossibilities(String[] forbiddenPattern, int n) {
        List<String> realPatterns = getPatternsWithoutSubpattern(forbiddenPattern);
        long leftPossibility = getPower(2, n);

        for (String p : realPatterns) {
            leftPossibility -= getPower(2, n - p.length());
        }
        return leftPossibility;
    }

    public static long getPower(int base, int n) {
        long res = 1;
        while (n >0) {
            res *= base;
            n--;
        }
        return res;
    }

    public static boolean checkIfIsSubsetOfFormer(List<String> formerPatterns, String currentP) {
        for (String fp : formerPatterns) {
            if (currentP.startsWith(fp)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getPatternsWithoutSubpattern (String[] forbiddenPattern) {
        List<String> formerPatterns = new ArrayList<>();
        Arrays.sort(forbiddenPattern, (a , b) -> (a.length() - b.length()));
        for (String p : forbiddenPattern) {
            boolean isSubsetOfFormerPatterns = checkIfIsSubsetOfFormer(formerPatterns, p);
            if (!isSubsetOfFormerPatterns) {
                formerPatterns.add(p);
            }
        }
        return formerPatterns;
    }
}
