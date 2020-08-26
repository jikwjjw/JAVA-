package letcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumIII {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        System.out.println(res);
        return res.size();
    }

    private static void dfs(TreeNode root, int target) {
        if (root == null) return;
        target -= root.val;
        list.add(root.val);
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        list.remove(list.size() - 1);
        return;
    }

    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t_3 = new TreeNode(-3);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t11 = new TreeNode(11);
        TreeNode t3_ = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(-2);


        t10.left = t5;
        t10.right = t_3;
        t5.left = t3;
        t5.right = t2;
        t_3.right = t11;
        t3.left = t3_;
        t3.right = t_2;
        t2.right = t1;
        System.out.println(pathSum(t10, 8));
    }
}
