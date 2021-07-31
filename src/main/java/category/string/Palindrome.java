package category.string;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int i = 0;
        int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String in = "abcdcba";
        System.out.println(isPalindrome(in));
    }
}
