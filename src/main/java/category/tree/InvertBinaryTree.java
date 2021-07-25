package category.tree;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) {
            return;
        }
        swap(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void swap(BinaryTree tree) {
        if (tree.left != null) {
            if (tree.right != null) {
                BinaryTree tmp = tree.left;
                tree.left = tree.right;
                tree.right  = tmp;
            } else {
                tree.right = tree.left;
                tree.left = null;
            }
        } else {
            tree.left = tree.right;
            tree.right = null;
        }

    }



    public static void main(String[] args) {

        //        1
        //       / \
        //      2   3
        //     / \  / \
        //    4   5 6  7
        //    /\
        //   8  9
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree four = new BinaryTree(4, eight, nine);
        BinaryTree five = new BinaryTree(5);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree three = new BinaryTree(3, six, seven);
        BinaryTree one = new BinaryTree(1, two, three);
        invertBinaryTree(one);
        System.out.println("hhhh");

    }
}
