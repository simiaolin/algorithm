package daily;

import javafx.util.Pair;

import java.util.*;

public class Jan29 {


     public List<List<Integer>> verticalTraversal(TreeNode root) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       //依靠treemap来保证x的顺序
         //依靠treeset来保证y的顺序 以及同y的时候的value的大小顺序
       TreeMap<Integer, TreeSet<ValueWithY>> treeMapRes = new TreeMap<Integer, TreeSet<ValueWithY>>();
       Queue<Pair<ValueXAndY, TreeNode>> q = new LinkedList<Pair<ValueXAndY, TreeNode>>();
       q.add(new Pair<ValueXAndY, TreeNode>(new ValueXAndY(0,0), root));
       while (!q.isEmpty()) {
           Pair<ValueXAndY, TreeNode> head = q.poll();
           Integer xValue = head.getKey().xValue;
           Integer yValue = head.getKey().yValue;
           TreeNode node = head.getValue();
           if (treeMapRes.containsKey(xValue)) {
            treeMapRes.get(xValue).add(new ValueWithY(node.val, yValue));
           } else {
               TreeSet<ValueWithY> ts = new TreeSet<ValueWithY>();
               ts.add(new ValueWithY(node.val, yValue));
               treeMapRes.put(xValue, ts);
           }
           if (node.left != null) {
               q.add(new Pair<ValueXAndY, TreeNode>(new ValueXAndY(xValue - 1,yValue + 1), node.left));
           }

           if (node.right != null) {
               q.add(new Pair<ValueXAndY, TreeNode>(new ValueXAndY(xValue + 1,yValue + 1), node.right));

           }
       }

       for (Map.Entry<Integer, TreeSet<ValueWithY>> entry : treeMapRes.entrySet()) {
           res.add(getOrderedListFromTreeset(entry.getValue()));
       }
        return res;
    }
     public List<Integer> getOrderedListFromTreeset(TreeSet<ValueWithY> ts) {
         List<Integer> res =  new ArrayList<Integer>();
        for (ValueWithY v : ts){
            res.add(v.val);
        }
        return res;
    }

    class ValueXAndY {
        Integer xValue;
        Integer yValue;
        public ValueXAndY(Integer x, Integer y) {
            xValue = x;
            yValue = y;
        }
    }
    class ValueWithY implements Comparable<ValueWithY>{
        Integer val;
        Integer yValue;
        public ValueWithY(Integer val, Integer yValue) {
            this.val = val;
            this.yValue = yValue;
        }

        public int compareTo(ValueWithY o) {
            if (yValue < o.yValue) {
                return -1;
            } else if (yValue > o.yValue) {
                return 1;
            } else if (val < o.val) {
                return -1;
            } else if (val > o.val) {
                return 1;
            } else  {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
         Jan29 j = new Jan29();
        TreeNode b =  new TreeNode(15);
        TreeNode c = new TreeNode(7);
        TreeNode a = new TreeNode(20, b, c);
        TreeNode m = new TreeNode(3, new TreeNode(9), a);
        List<List<Integer>> res = j.verticalTraversal(m);
        for (List<Integer> r : res) {
            for (Integer e : r) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

