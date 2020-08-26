package letcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 把二叉搜索树转换为累加树
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST {
    static int num = 0;

    public static TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        System.out.println(list);
        return root;
    }


    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.right, list);
        root.val = root.val + num;
        num = root.val;
        list.add(root.val);
        dfs(root.left, list);
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t13 = new TreeNode(13);
        t5.left = t2;
        t5.right = t13;
        convertBST(t5);
    }
}
