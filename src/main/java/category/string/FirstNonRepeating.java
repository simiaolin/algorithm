package category.string;

import java.util.HashMap;

public class FirstNonRepeating {
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : string.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (m.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abcdcaf";
        System.out.println(new FirstNonRepeating().firstNonRepeatingCharacter(str));
    }
}
