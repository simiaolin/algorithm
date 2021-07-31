package category.string;

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        String res = str.substring(0,1);
        for (int i = 1; i < str.length(); i++) {
            String oddMirror = mirror(str, i, false);
            if (oddMirror.length() > res.length()) {
                res = oddMirror;
            }
            if (str.charAt(i) == str.charAt(i-1)) {
                String evenMirror = mirror(str, i, true);
                if (evenMirror.length() > res.length()) {
                    res = evenMirror;
                }
            }
        }
        return res;
    }

    public static String mirror(String str, int i, boolean isEven) {
        int start = isEven? i-1: i;
        int end = i;
        while (start - 1 >= 0 && end + 1 <= str.length() - 1 && str.charAt(start-1) == str.charAt(end+1)) {
            start--;
            end++;
        }
        return str.substring(start, end+1);
    }



    public static void main(String[] args) {
        String s = "abaxyzzyxf";
        System.out.println(longestPalindromicSubstring(s));
    }
}
