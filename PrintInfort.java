package letcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的先序遍历
 */
public class PrintInfort {
    static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 非递归方式
     *
     * @param root 根节点
     * @return 先序遍历的结果
     */
    public static ArrayList<Integer> printInfort(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                list.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return list;
    }

    /**
     * 递归方式
     *
     * @param root
     */
    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        System.out.println(printInfort(root));
    }
}
