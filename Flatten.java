package letcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten {
    /**
     * 先序遍历
     */
    List<TreeNode> list = new ArrayList<TreeNode>();

    public void flatten1(TreeNode root) {
        preorderTraversal(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    /**
  
     * 通过后续遍历,我们依次遍历 6 5 4 3 2 1，然后每遍历一个节点就将当前节点的右指针更新为上一个节点。
     * 遍历到 5，把 5 的右指针指向 6。6 <- 5 4 3 2 1。
     * 遍历到 4，把 4 的右指针指向 5。6 <- 5 <- 4 3 2 1。
     */

    // 前一个根结点
    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
