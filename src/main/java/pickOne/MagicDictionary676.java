package pickOne;

//1。用hashmap的方法是 20% 7%
//2. 用一棵大树的方法， 9% 50%  空间换时间。
public class MagicDictionary676 {
    /**
     * Initialize your data structure here.
     */
    Trie trie;

    public MagicDictionary676() {
        trie = new Trie();
    }


    class Trie {
        Trie[] children;
        boolean isEndOfTheWord;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insert(trie, s);
        }
    }

    public boolean search(String searchWord) {
        return search(trie, searchWord, 0, 0);
    }


    public void insert(Trie root, String word) {
        Trie currentRoot = root;
        char[] charArr = word.toCharArray();
        for (char c : charArr) {
            int currentIndex = c - 'a';
            if (currentRoot.children[currentIndex] == null) {
                currentRoot.children[currentIndex] = new Trie();
            }
            currentRoot = currentRoot.children[currentIndex];

        }
        currentRoot.isEndOfTheWord = true;
    }

    public boolean search(Trie root, String word, int beginIndex, int modifiedCount) {
        return dfs(root, word.toCharArray(), beginIndex, modifiedCount);
    }

    public boolean dfs(Trie root, char[] charArr, int index, int modifiedCount) {
        //中止条件：走到叶子结点
        if (index == charArr.length) {
            if (modifiedCount == 1 && root.isEndOfTheWord) {
                return true;
            } else {
                return false;
            }
        }

        //遍历各个字节点
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                if (charArr[index] - 'a' == i) {
                    if (dfs(root.children[i], charArr, index + 1, modifiedCount)) {
                        return true;
                    }
                } else {
                    if (dfs(root.children[i], charArr, index + 1, modifiedCount + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

        //Your MagicDictionary object will be instantiated and called as such:
        MagicDictionary676 obj = new MagicDictionary676();
        String[] dictionary = new String[]{"hello", "leetcode"};
        obj.buildDict(dictionary);
        String searchWord = "hello";
        String a = "hhllo";
        String b = "hell";
//        boolean re1 = obj.search(searchWord);
        boolean re2 = obj.search(a);
//        boolean re3 = obj.search(b);

//        System.out.println(re1);
        System.out.println(re2);
//        System.out.println(re3);
    }
}
