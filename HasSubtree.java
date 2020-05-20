package Tree;

/*public class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}*/
public class HasSubtree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		// 如果找到与子树相同根的值，走判断方法
		if (root1.val == root2.val) {
			if (judge(root1, root2)) {
				return true;
			}
		}
		// 遍历左字数和右子树，找相同的根值
		return HasSubtree(root1.left, root2) || HasSubtree(root1.rigth, root2);
	}

	public boolean judge(TreeNode root, TreeNode subtree) {
		//子结构已经循环完毕，代表全部匹配
		if (subtree == null) {
			return true;
		}
		//大树已经全部完毕，并未匹配成功
		if (root == null) {
			return true;
		}
		//根节点相等，判断左右孩子节点
		if (root.val == subtree.val) {
			return judge(root.left, subtree.left) && judge(root.right, subtree.right);
		}
	}
}
