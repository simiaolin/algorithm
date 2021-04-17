package category.tree;

public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

     BinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
     BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}