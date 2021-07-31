package category.string;

public class Runlength {

    // handle the last run
    // neat code!
    public String runLengthEncoding(String string) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i-1)  || cnt == 9) {
                sb.append(cnt);
                sb.append(string.charAt(i-1));
                cnt = 1;
            } else {
                cnt++;
            }
        }

        sb.append(cnt);
        sb.append(string.charAt(string.length()-1));

        return sb.toString();
    }

    public static void main(String[] args) {
        String in = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(new Runlength().runLengthEncoding(in));
    }
}
