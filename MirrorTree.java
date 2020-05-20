package Tree;

import java.util.Stack;


//操作给定的二叉树，将其变换为源二叉树的镜像

/*public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}*/

public class MirrorTree {
	public void mirror(TreeNode root) {
		// 递归交换子树
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	/**
	 * 利用栈来交换子树
	 * continue：结束本次循环
	 * 使用continue为了让深度遍历到达叶节点时，栈中的已交换的节点出去，只剩需要交换的节点
	 * @param root
	 */
	public void mirror2(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = null;
		TreeNode temp = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if(cur = null){
				continue;//跳过本次循环中余下尚未执行的语句，仅结束本次循环
			}
			if(cur.left == null && cur.right==null) {
                continue;//深度遍历，先左后有
            }
			temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			stack.push(cur.left);
			stack.push(cur.right);
		}
	}
}
