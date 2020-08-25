package letcode.tree;

/**
 * 二叉树的公共祖先节点
 */
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(4);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;
        System.out.println(lowestCommonAncestor(t1, t3, t6).val);
    }
}
