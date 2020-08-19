package letcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 求路径
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 *  返回：[[1, 2], [1,3]]
 */
public class SumNumbers {
    private int sum = 0;
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> sumNumbers(TreeNode root) {
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left);
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

        System.out.println(sumNumbers(root));
    }
}

