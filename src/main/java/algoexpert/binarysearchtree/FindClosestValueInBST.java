package algoexpert.binarysearchtree;

//time & space complexity
//avg :o(logn) & o(1)
//worst : o(n) & o(1) ???? todo
public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
       return findClosestValueInBst(tree, target, tree.value);

    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return closest;
        }
    }
    public static void main(String[] args) {
        BST one = new BST(1);
        BST two = new BST(2, one,null);
        BST five_leaf = new BST(5);
        BST five = new BST(5, two, five_leaf);
        BST fourteen = new BST(14);
        BST thirteen = new BST(13, null, fourteen);
        BST twentytwo = new BST(22);
        BST fifteen = new BST(15, thirteen, twentytwo);
        BST ten = new BST(10, five, fifteen);
        int res = findClosestValueInBst(ten, 12);
        System.out.println(res);
    }
}
