package category.tree;

import java.util.Stack;


public class KthLargestValueInBST {

    public static int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();

        while (true) {
            while (tree != null) {
                stack.add(tree);
                tree = tree.right;
            }
            tree = stack.pop();
            if (--k == 0) return tree.value;
            tree = tree.left;
        }

    }

    public static void main(String[] args) {
        BST b = new BST(15);
        int[] a = new int[] {5, 20, 2, 5, 17,  22, 1, 3};
        for (int n : a) {
            b.insert(n);
        }
        int res = findKthLargestValueInBst(b, 3);
        System.out.println(res);
    }
}
