package codejam.april;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class EvenDigits {
    static String readpath = "./ins/small-practice.in";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader(readpath));

        // get total number
        int T = in.nextInt();
        // handle each task
        for (int i = 0; i < T; i++) {
            // get number of ingredients
            // store each optimal distance
            long D = in.nextLong();

            System.out.println("Case #" + (i + 1) + ": " + getLeastMove(D));
        }
        in.close();
    }

    public static long getLeastMove(long d) {
        String stringForm = String.valueOf(d);
        int size = stringForm.length();
        int idx = 0;
        while (idx < size - 1) {
            if (isOdd(stringForm.charAt(idx))) break;
            else idx++;
        }
        if (idx == size - 1 && !isOdd(stringForm.charAt(idx))) {
            return 0;
        }


        char c = stringForm.charAt(idx);
        int firstOddDigit = c - '0';
        if (firstOddDigit == 9) {
            long sbLess = 0;
            sbLess += 8 * Math.pow(10, size - idx - 1);
            for (int i = idx + 1; i < size; i++) {
                sbLess += 8 * Math.pow(10, size - i - 1);
            }
            return Long.valueOf(String.valueOf(d).substring(idx)) - sbLess;
        } else {
            long sbLess = 0;
            long sbGreater = 0;
            sbGreater += (firstOddDigit + 1) * Math.pow(10, size - idx - 1);
            sbLess += (firstOddDigit - 1) * Math.pow(10, size - idx - 1);
            for (int i = idx + 1; i < size; i++) {
                sbLess += 8 * Math.pow(10, size - i - 1);

            }
            long hasChangedD = Long.valueOf(String.valueOf(d).substring(idx));
            long toGreater = sbGreater - hasChangedD;
            long toLess = hasChangedD - sbLess;
            return Math.min(toGreater, toLess);
        }
    }

    public static boolean isOdd(char c) {
        if (((c - '0') & 1) == 0) {
            return false;
        } else {
            return true;
        }
    }

}
