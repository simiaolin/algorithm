package category.tree;

import java.util.*;
 class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.

        Stack<Integer> sum = new Stack<>();
        Stack<Integer> path = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, sum, path, res);
        return res;

    }

    public static void preOrder(BinaryTree root, Stack<Integer> sum, Stack<Integer> path, List<Integer> res) {

        if (root.left == null && root.right == null) {   //leaf
            int currentSum = (sum.size() > 0) ? sum.peek():0;
            res.add(currentSum + root.value);
        } else {
            //add path and sum;
            path.push(root.value);
            if (sum.size() > 0) {
                sum.push(sum.peek()+root.value);
            } else {
                sum.push(root.value);
            }
            if (root.left != null) {
                preOrder(root.left, sum, path, res);
            }

            if (root.right != null) {
                preOrder(root.right, sum, path, res);
            }

            path.pop();
            sum.pop();
        }

    }

    public static void main(String[] args) {
        BinaryTree eight = new BinaryTree(8);
        BinaryTree night = new BinaryTree(9);
        BinaryTree four = new BinaryTree(4, eight, night);
        BinaryTree ten = new BinaryTree(10);
        BinaryTree five = new BinaryTree(5, ten, null);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree three = new BinaryTree(3, six, seven);
        BinaryTree one = new BinaryTree(1, two, three);

        BinaryTree root = one;
        List<Integer> res = branchSums(root);
        for (Integer i : res) {
            System.out.println(i);
        }

    }
}
