package pickOne;


import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[][] distanceMatrix = getConnectedMatrix(beginWord, endWord, wordList);
        int[] huristicValueArr = huristicValueArr(wordList, endWord, beginWord);
        PriorityQueue<String> paths = new PriorityQueue<>(
                (s1, s2) -> getFValue(huristicValueArr, s1) - getFValue(huristicValueArr, s2));
        paths.add(Integer.toString(wordList.size()));
        while (!paths.isEmpty() && !goalFound(paths, wordList.size() + 1)) {
            String currentShortestPath = paths.poll();
            List<String> childPaths = getChildPaths(currentShortestPath, distanceMatrix);
            if (childPaths.size() == 0) {
                continue;
            } else {
                for (String child : childPaths) {
                    paths.offer(child);
                }
            }

        }
        if (paths.isEmpty()) {
            return 0;
        } else {
            return paths.peek().length();
        }
    }

    //1 for connected
    //0 for disconnected
    public int[][] getConnectedMatrix(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        int[][] connectedMatrix = new int[size + 2][size + 2];
        for (int i = 0; i < size; i++)
            for (int j = i+1; j < size; j++) {
                int connectness  = checkAdjacentWords(wordList.get(i), wordList.get(j));
                connectedMatrix[i][j] = connectness;
                connectedMatrix[j][i] = connectness;
            }
        for (int i = 0 ; i < size; i++) {
            connectedMatrix[i][size] = checkAdjacentWords(beginWord, wordList.get(i));
            connectedMatrix[size][i] = checkAdjacentWords(beginWord, wordList.get(i));

            connectedMatrix[i][size+1] = checkAdjacentWords(wordList.get(i), endWord);
            connectedMatrix[size+1][i] = checkAdjacentWords(wordList.get(i), endWord);
        }
        return connectedMatrix;
    }

    public int checkAdjacentWords(String a, String b) {
        if (getDistanceBetweenTwoWords(a, b) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int[] huristicValueArr(List<String> wordList, String endWord, String beginWord) {
        int size = wordList.size();
        int[] res = new int[size + 2];
        res[size] = getDistanceBetweenTwoWords(endWord, beginWord);
        res[size + 1] = 0;
        for (int i= 0; i < size; i++) {
            res[i] = getDistanceBetweenTwoWords(endWord, wordList.get(i));
        }

        return res;
    }

    public int getDistanceBetweenTwoWords(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean goalFound(Queue<String> paths, int indexOfEndWord) {
        String firstPath = paths.peek();
        //注意使用equals 而不是==
        if (firstPath.substring(firstPath.length() - 1).equals(Integer.toString(indexOfEndWord))) {
            return true;
        } else {
            return false;
        }
    }


    public List<String> getChildPaths(String path, int[][] distanceMatrix) {
        List<String> res = new ArrayList<>();
        int lastNode = Integer.parseInt(path.substring(path.length() - 1));
        for (int i = 0; i < distanceMatrix[0].length; i++) {
            if (distanceMatrix[lastNode][i] == 1) {
                String possibleChild = path + i;
                if (checkLoop(possibleChild)) {
                    res.add(possibleChild);
                }
            }
        }
        return res;

    }

    public boolean checkLoop(String path) {
        Set<Byte> characters = new HashSet<>();
        for (Byte s : path.getBytes()) {
           boolean addNew = characters.add(s);
           if (!addNew) {
               return false;
           }
        }
        return true;
    }

    public int getFValue(int[] huristicValueArr, String path) {
        int h_value = huristicValueArr[Integer.valueOf(path.substring(path.length() - 1))];
        int cost = path.length();
        return h_value + cost;
    }
    public static void main(String[] args) {
        WordLadder127 w = new WordLadder127();
        String b = "hit";
        String e = "cog";
        List<String> wl = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wl2 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(w.ladderLength(b, e, wl));
        System.out.println(w.ladderLength(b, e, wl2));

    }
}
