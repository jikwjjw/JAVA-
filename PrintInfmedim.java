package letcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class PrintInfmedim {
    static ArrayList<Integer> list = new ArrayList<>();


    /**
     * 非递归方式(栈)
     *
     * @param root 根节点
     * @return 中序遍历的结果
     */
    public static ArrayList<Integer> printStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
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
        list.add(root.val);
        dfs(root.right);
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

        System.out.println(printStack(root));
    }
}
