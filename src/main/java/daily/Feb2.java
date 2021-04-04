package daily;

public class Feb2 {

    public TreeNode2 trimBST(TreeNode2 root, int low, int high) {
            return null;
    }

    public static void main(String[] args) {
        Feb2 f = new Feb2();
        TreeNode2 t1 = new TreeNode2(1);
        TreeNode2 t2 = new TreeNode2(2, t1, null);
        TreeNode2 t3 = new TreeNode2(0, null, t2);
        TreeNode2 t4 = new TreeNode2(4);
        TreeNode2 t5 = new TreeNode2(3, t3, t4);
        System.out.println(f.trimBST(t5, 1, 3));

    }


}


class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2() {}
    TreeNode2(int val) { this.val = val; }
    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
