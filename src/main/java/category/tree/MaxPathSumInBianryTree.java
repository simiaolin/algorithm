package category.tree;
import java.util.concurrent.atomic.AtomicInteger;

class MaxPathSumInBianryTree {
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        getMaxForCurrentNode(tree, max);
        return max.get();

    }

    public static int getMaxForCurrentNode(BinaryTree root, AtomicInteger max) {
        if (root.left == null && root.right == null) {
            if (root.value > max.get()) {      //pay attention to the single node in the tree!!!
                max.set(root.value);
            }
            return root.value;
        }

        int leftMax = (root.left == null) ? Integer.MIN_VALUE : getMaxForCurrentNode(root.left, max);
        int rightMax = (root.right == null) ? Integer.MIN_VALUE : getMaxForCurrentNode(root.right, max);
        int maxOfChildren = Integer.max(leftMax, rightMax);
        int maxOfCurrentRoot = root.value;
        if (leftMax > 0) {
            maxOfCurrentRoot += leftMax;
        }
        if (rightMax > 0) {
            maxOfCurrentRoot += rightMax;
        }

        //based on current node.
        if (maxOfCurrentRoot > max.get()) {
            max.set(maxOfCurrentRoot);
        }

        //track a single path back for parent
        if (maxOfChildren > 0) {
            return root.value + maxOfChildren;
        } else {
            return root.value;
        }
    }
    public static void main(String[] args) {
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree three = new BinaryTree(3, six, seven);
        BinaryTree one = new BinaryTree(1, two, three);
        System.out.println(maxPathSum(one));

        BinaryTree singleOne = new BinaryTree(1);
        System.out.println(maxPathSum(singleOne));
    }
}
