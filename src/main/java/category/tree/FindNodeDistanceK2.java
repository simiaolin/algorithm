package category.tree;

import sun.lwawt.macosx.CThreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNodeDistanceK2 {
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        dfs(tree, target, k, res);
        return res;
    }

    public int dfs(BinaryTree tree, int target, int k, ArrayList<Integer> res) {
        if (tree == null) {
            return -1;
        } else if (tree.value == target) {
            addSubtree(tree, 0, k, res);
            return 1;   // only return positive after the target found.
        } else {
            int left = dfs(tree.left, target, k, res);
            int right = dfs(tree.right, target, k, res);
            if (left != -1) {
                if (k == left) {
                    res.add(tree.value);
                } else {
                    addSubtree(tree.right, left + 1, k, res);
                }
                return left + 1;  // add one generation by generation
            } else if (right != -1) {
                if (k == right) {
                    res.add(tree.value);
                } else {
                    addSubtree(tree.left, right + 1, k, res);
                }
                return right + 1;
            } else {
                return -1;
            }
        }
    }

    public void addSubtree(BinaryTree tree, int l, int k, ArrayList<Integer> res) {
        if (tree == null || l > k) {     //be careful
            return;
        }
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty() && l++ < k) {
            int length = q.size();
            while (length-- > 0) {
                BinaryTree head = q.poll();
                if (head.left != null) {
                    q.add(head.left);
                }
                if (head.right != null) {
                    q.add(head.right);
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll().value);
        }

    }


    public static void main(String[] args) {
        BinaryTree one = getExampleTwo();
        FindNodeDistanceK2 f = new FindNodeDistanceK2();
        List<Integer> res = f.findNodesDistanceK(one, 2, 3);
        System.out.println(res);
    }

    public static BinaryTree getExampleOne() {

        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //            /\
        //           7  8
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree six = new BinaryTree(6, seven, eight);
        BinaryTree three = new BinaryTree(3, null, six);
        BinaryTree one = new BinaryTree(1, two, three);
        return one;
    }

    public static BinaryTree getExampleTwo() {
        //    1-2-3-4-5
        BinaryTree f = new BinaryTree(5);
        BinaryTree fo = new BinaryTree(4, f, null);
        BinaryTree t = new BinaryTree(3, fo, null);
        BinaryTree two = new BinaryTree(2, t, null);
        BinaryTree o = new BinaryTree(1, two, null);
        return o;
    }
}
