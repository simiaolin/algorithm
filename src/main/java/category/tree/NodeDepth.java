package category.tree;

public class NodeDepth {
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        if (root == null) {
            return 0;
        } else {
            return nodeDepths(root, 0);
        }

    }

    public static int nodeDepths(BinaryTree root, int depth) {
        // Write your code here.
        int res = depth;
        if (root.left != null) {
            res += nodeDepths(root.left, depth + 1);
        }
        if (root.right != null) {
            res += nodeDepths(root.right, depth + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);
        System.out.println(actual);
        
    }
}
