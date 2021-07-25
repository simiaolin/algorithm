package category.tree;


import java.util.LinkedList;
import java.util.List;

public class FindNodeDistanceK {
        List<Integer> ans;
        int  K;
        BinaryTree target;
        public  List<Integer> findNodesDistanceK(BinaryTree root, BinaryTree target, int K) {
            ans = new LinkedList();
            this.target = target;
            this.K = K;
            dfs(root);
            return ans;
        }

        // Return vertex distance from node to target if exists, else -1
        // Vertex distance: the number of vertices on the path from node to target
        public int dfs(BinaryTree node) {
            if (node == null)
                return -1;
            else if (node == target) {
                subtree_add(node, 0);
                return 1;
            } else {
                int L = dfs(node.left), R = dfs(node.right);
                if (L != -1) {
                    if (L == K) ans.add(node.value);
                    subtree_add(node.right, L + 1);
                    return L + 1;
                } else if (R != -1) {
                    if (R == K) ans.add(node.value);
                    subtree_add(node.left, R + 1);
                    return R + 1;
                } else {
                    return -1;
                }
            }
        }

        // Add all nodes 'K - dist' from the node to answer.
        public void subtree_add(BinaryTree node, int dist) {
            if (node == null) return;
            if (dist == K)
                ans.add(node.value);
            else {
                subtree_add(node.left, dist + 1);
                subtree_add(node.right, dist + 1);
            }
        }


    public static void main(String[] args) {


        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //            /\
        //           7  8
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree six = new BinaryTree(6, seven, eight);
        BinaryTree three = new BinaryTree(3, null, six);
        BinaryTree one = new BinaryTree(1, two, three);
        FindNodeDistanceK f = new FindNodeDistanceK();
        List<Integer> res = f.findNodesDistanceK(one, three, 2);
        System.out.println(res);
    }
}
