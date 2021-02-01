package utils;

import java.io.*;

public class ReadBigArrayFromFile {
    static public int[] getArrayFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s = br.readLine();
        String[] ss = s.substring(1, s.length() - 1).split(",");
        int[] res = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            res[i] = Integer.valueOf(ss[i]);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String f1 = "src/main/resources/arr1";
        String f2 = "src/main/resources/arr2";
        int[] arr1 = ReadBigArrayFromFile.getArrayFromFile(f1);
        int[] arr2 = ReadBigArrayFromFile.getArrayFromFile(f2);
        System.out.println("first " + arr1[0]);
        System.out.println("last " + arr1[arr1.length - 1]);
    }


}
