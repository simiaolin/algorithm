package category.tree;

public class ValidateTreeNodes {
    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        if (validateDescendant(nodeOne, nodeTwo)) {
            return validateDescendant(nodeTwo, nodeThree);
        } else {
            return validateDescendant(nodeThree, nodeTwo) && validateDescendant(nodeTwo, nodeOne);
        }
    }

    public static boolean validateDescendant(BST node1, BST node2) {
        BST cur = node2;
        while (cur != null) {
            if (cur == node1) {
                return true;
            }
            if (node1.value < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        BST b = new BST(5);
        int[] a = new int[] {2, 7, 1, 4, 6, 8, 0, 3};
        for (int n : a) {
            b.insert(n);
        }
        boolean res = validateThreeNodes(b, b.left, b.left.right.left);
        System.out.println(res);
    }
}
