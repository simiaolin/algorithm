package category.string;

import java.util.HashMap;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (char c : characters.toCharArray()) {
            if (characterMap.containsKey(c)) {
                characterMap.put(c, characterMap.get(c) + 1);
            } else {
                characterMap.put(c, 1);
            }
        }

        for (char c : document.toCharArray()) {
            if (characterMap.containsKey(c) && characterMap.get(c) != 0) {
                characterMap.put(c, characterMap.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String cs = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(new GenerateDocument().generateDocument(cs, document));
    }
}
