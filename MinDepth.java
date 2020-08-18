package letcode.tree;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class MinDepth {
    /**
     * 二叉树的最小深度
     * @param root 
     * @return 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) return Math.max(left, right) + 1;//一个叶子的情况（即为二叉树的深度）
        return Math.min(left, right) + 1;//多个叶子情况（选叶子节点的最小深度）
    }
}
