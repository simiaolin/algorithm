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
            int D = in.nextInt();

            System.out.println("Case #" + (i + 1) + ": " + getLeastMove(D));
        }
        in.close();
    }

    public static int getLeastMove(int d) {
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
            int sbLess = 0;
//            for (int i = 0; i < idx; i++) {
//                sbLess += (stringForm.charAt(i) - '0') * Math.pow(10, size - i - 1);
//            }
            sbLess += 8 * Math.pow(10, size - idx - 1);
            for (int i = idx + 1; i < size; i++) {
                sbLess += 8 * Math.pow(10, size - i - 1);
            }
            return Integer.valueOf(String.valueOf(d).substring(idx)) - sbLess;
        } else {
            int sbLess = 0;
            int sbGreater = 0;
//            for (int i = 0; i < idx; i++) {
//                sbGreater += (stringForm.charAt(i) - '0') * Math.pow(10, size - i - 1);
//            }
//            sbLess = sbGreater;
            sbGreater += (firstOddDigit + 1) * Math.pow(10, size - idx - 1);
            sbLess += (firstOddDigit - 1) * Math.pow(10, size - idx - 1);
            for (int i = idx + 1; i < size; i++) {
                sbLess += 8 * Math.pow(10, size - i - 1);

            }
            int hasChangedD = Integer.valueOf(String.valueOf(d).substring(idx));
            int toGreater = sbGreater - hasChangedD;
            int toLess = hasChangedD - sbLess;
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
