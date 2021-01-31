package pickOne;



import java.util.*;

//注意用用array存path，而不是string，因为有可能是11。
//string比较的时候注意不要用==
public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int endWordIndexInWordList = getGoldIndex(wordList, endWord);
        if (endWordIndexInWordList == -1) return 0;

        int[][] distanceMatrix = getConnectedMatrix(beginWord, endWord, wordList);
        PriorityQueue<int[]> paths = new PriorityQueue<>(
                (s1, s2) -> getFValue(distanceMatrix, s1, endWordIndexInWordList) - getFValue(distanceMatrix, s2, endWordIndexInWordList));
        paths.add(new int[]{wordList.size()});
        while (!paths.isEmpty() && !goalFound(paths, endWordIndexInWordList)) {
            int[] currentShortestPath = paths.poll();
            List<int[]> childPaths = getChildPaths(currentShortestPath, distanceMatrix);
            if (childPaths.size() == 0) {
                continue;
            } else {
                for (int[] child : childPaths) {
                    paths.offer(child);
                }
            }

        }
        if (paths.isEmpty()) {
            return 0;
        } else {
            return paths.peek().length;
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

    public boolean goalFound(Queue<int[]> paths, int indexOfEndWord) {
        int[] firstPath = paths.peek();
        //注意使用equals 而不是==
        if (firstPath[firstPath.length - 1] == indexOfEndWord) {
            return true;
        } else {
            return false;
        }
    }


    public List<int[]> getChildPaths(int[] path, int[][] distanceMatrix) {
        List<int[]> res = new ArrayList<>();
        int lastNode = path[path.length - 1];
        for (int i = 0; i < distanceMatrix[0].length - 1; i++) {
            if (distanceMatrix[lastNode][i] == 1) {
                if (checkLoop(path, i)) {
                    int[] possibleChild = Arrays.copyOf(path, path.length + 1);
                    possibleChild[path.length] = i;
                    res.add(possibleChild);
                }
            }
        }
        return res;

    }

    public boolean checkLoop(int[] orginalPath, int newAdd) {
       for (int original : orginalPath) {
           if (original == newAdd) {
               return false;
           }
       }
       return true;
    }

    public int getGoldIndex(List<String> wordList, String endString) {
        for (int i =0;i < wordList.size(); i++) {
            if (wordList.get(i).equals(endString)) {
                return i;
            }
        }

        return -1;
    }

    public int getFValue(int[][] distanceMatrix, int[] path, int endWordIndexInWordListint) {
        int h_value = distanceMatrix[endWordIndexInWordListint][path[path.length - 1]];
        int cost = path.length;
        return h_value + cost;
    }
    public static void main(String[] args) {
        WordLadder127 w = new WordLadder127();
        String b = "hit";
        String e = "cog";
        String b3 = "ymain";
        String e3 = "oecij";
        String b4 = "cet";
        String e4 = "ism";

        List<String> wl = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wl2 = Arrays.asList("hot","dot","dog","lot","log");
        List<String> wl3 = Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
        List<String> wl4 = Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        System.out.println(w.ladderLength(b, e, wl));
        System.out.println(w.ladderLength(b, e, wl2));
        System.out.println(w.ladderLength(b3, e3, wl3));
        System.out.println(w.ladderLength(b4, e4, wl4));

    }
}
