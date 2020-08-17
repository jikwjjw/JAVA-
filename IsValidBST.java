package letcode.tree;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class IsValidBST {
    long cur = Long.MIN_VALUE;

    /**
     * 输入为: [5,1,4,null,null,3,6]。
     *
     * @param root
     * @return false
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST1(root.left);
        if (cur >= root.val) return false;
        cur = root.val;
        boolean right = isValidBST1(root.right);
        return left && right;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
