package category.string;

import category.Utils;

import java.util.ArrayList;

public class ValidIPAddresses {

    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.

        int size = string.length();
        ArrayList<String> res = new ArrayList<>();
        for(int i = 1; i <= Integer.min(3, size ); i++) {
            String first = string.substring(0, i);
            if (!isValid(first)) continue;

            for (int j = i; j <= Integer.min(i+3, size); j++) {
                String second = string.substring(i, j);
                if (!isValid(second)) continue;

                for (int k = j; k <= Integer.min(j+3, size); k++) {
                    String third = string.substring(j, k);
                    String fourth = string.substring(k, size);
                    if (isValid(third) && isValid(fourth)) {
                        res.add(getIP(first, second, third, fourth));
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String str) {
        if (str.length() >= 1 && str.length() <= 3) {
            if (str.charAt(0) == '0' && str.length() > 1) {
                return false;
            }

            int intValue = Integer.parseInt(str);
            if (intValue >= 0 && intValue <= 255) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getIP(String one, String two, String three, String four) {
        StringBuilder sb = new StringBuilder();
        sb.append(one);
        sb.append(".");
        sb.append(two);
        sb.append(".");
        sb.append(three);
        sb.append(".");
        sb.append(four);
        return sb.toString();
    }

    public static void main(String[] args) {
        String in = "3700100";
        ArrayList<String> res = new ValidIPAddresses().validIPAddresses(in);
        Utils.printArray(res);
        System.out.println(123);
    }
}
