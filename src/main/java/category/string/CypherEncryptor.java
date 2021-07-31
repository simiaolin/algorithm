package category.string;

public class CypherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        key = key % 26;   // in case key is greater than 26
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)  {
            if (str.charAt(i) + key > 'z') {
                sb.append((char)(str.charAt(i) + key - 26));   // be careful of the usage of (char)a+26  VS (char) (a+26)
            } else {
                sb.append((char)(str.charAt(i) + key));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String in = "xyz";
        int k = 2;
        System.out.println(caesarCypherEncryptor(in, k));
    }
}
