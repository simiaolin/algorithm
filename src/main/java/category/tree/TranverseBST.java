package category.tree;

import java.util.ArrayList;
import java.util.List;

public class TranverseBST {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here
        inOrderTraverse1(tree, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        preOrderTraverse1(tree, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        postOrderTraverse1(tree, array);
        return array;
    }

    public static void inOrderTraverse1(BST tree, List<Integer> array) {
        if (tree == null) {
            return;
        }
        inOrderTraverse1(tree.left, array);
        array.add(tree.value);
        inOrderTraverse1(tree.right, array);
    }

    public static void preOrderTraverse1(BST tree, List<Integer> array) {
        if (tree == null) {
            return;
        }
        array.add(tree.value);
        preOrderTraverse1(tree.left, array);
        preOrderTraverse1(tree.right, array);
    }


    public static void postOrderTraverse1(BST tree, List<Integer> array) {
        if (tree == null) {
            return;
        }
        postOrderTraverse1(tree.left, array);
        postOrderTraverse1(tree.right, array);
        array.add(tree.value);
    }


    public static void main(String[] args) {
        BST a = new BST(1);
        BST aa = new BST(2,a, null);
        BST aaa = new BST(5);
        BST aaaa = new BST(5, aa, aaa);
        BST b = new BST(22);
        BST bb = new BST(15, null, b);
        BST bbb = new BST(10, aaaa, bb);
        List<Integer> inres = inOrderTraverse(bbb, new ArrayList<>());
        List<Integer> preres = preOrderTraverse(bbb, new ArrayList<>());
        List<Integer> postres = postOrderTraverse(bbb, new ArrayList<>());
        System.out.println(aa);


    }

}
