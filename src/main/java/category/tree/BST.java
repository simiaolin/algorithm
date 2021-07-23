package category.tree;

public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST(int value, BST left, BST right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
