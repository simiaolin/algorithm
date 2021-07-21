package category;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        Queue<Integer> b = new LinkedList<>();
        List<Integer> c = Arrays.asList(1,2,4);
        Set<Integer> s = new HashSet<>();
        HashMap<String, String> h = new HashMap<>();
        ArrayList<Integer> lis;
        Vector<Integer> v;
        PriorityQueue<String> p;
        h.put("a" , " a");
        h.put("a" , " b");


        Collections.sort(c, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : c) {
            System.out.println(i);
        }
    }
}
