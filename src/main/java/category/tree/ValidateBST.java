package category.tree;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBST(BST tree, int min, int max) {
        if (tree.value < min || tree.value >= max) {
            return false;
        }
        if (tree.left != null && !validateBST(tree.left, min, tree.value)) {
            return false;
        }
        if (tree.right != null && !validateBST(tree.right, tree.value, max)) {
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        BST a = new BST(100);
        BST b = new BST(5, null, a);
        BST c = new BST(15);
        BST d = new BST(10, b, c);
        boolean res = validateBst(d);
        System.out.println(res);
    }
}
