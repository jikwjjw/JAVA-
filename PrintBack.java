package letcode.tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 二叉树的后序遍历
 */
public class PrintBack {
    static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 单栈
     * 非递归方式(栈)
     *
     * @param root 根节点
     * @return 后序遍历的结果
     */
    public static ArrayList<Integer> printStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            boolean flag = true;
            TreeNode preNode = null;
            while (!stack.isEmpty() && flag == true) {
                root = stack.peek();
                if (root.right == preNode) {
                    root = stack.pop();
                    list.add(root.val);
                    if (stack.isEmpty()) {
                        return list;
                    } else {
                        preNode = root;
                    }
                } else {
                    root = root.right;
                    flag = false;
                }
            }
        }
        return list;
    }

    /**
     * 双栈
     *
     * @param root 根节点
     * @return 后序遍历的结果
     */
    public static List<Integer> printDoubleStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()) {
            root = stack2.pop();
            list.add(root.val);
        }
        return list;
    }

    /**
     * 后序遍历2
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return result;
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

        System.out.println(postorderTraversal(root));
    }
}
