package letcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打
 */

/*public class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}*/

/**
 * 利用队列进行二叉树的广度优先遍历
 *
 * @author ji
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> alist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        if (root == null) return alist;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            alist.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return alist;
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

        System.out.println(printFromTopToBottom(root));
    }
}
